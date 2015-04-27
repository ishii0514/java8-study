package java8_study.chapter3;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Question15 {
	public static void main( String[] args )
    {
		
    }
	
	public static class LatentImage{
		private Image in;
		private List<UnaryOperator<Color>> pendingOperations;
		
		private LatentImage(Image in){
			this.in = in;
			this.pendingOperations = new LinkedList<>();
		}
		
		public static LatentImage from(Image in){
			return  new LatentImage(in);
		}
		public LatentImage transform(UnaryOperator<Color> f){
			pendingOperations.add(f);
			return this;
		}
		public Image toImage(){
			int width = (int)in.getWidth();
			int height = (int)in.getHeight();
			WritableImage out = new WritableImage(width, height);
			for(int x =0;x< width; x++){
				for (int y = 0; y<height; y++){
					Color c = in.getPixelReader().getColor(x,y);
					for (UnaryOperator<Color> f: pendingOperations){
						c = f.apply(c);
					}
					out.getPixelWriter().setColor(x,y,c);
				}
			}
			return out;
		}
		public Image toImageParallel(){
			int WIDTH = (int) in.getWidth();
	        int HEIGHT = (int) in.getHeight();
	        
	        Color[][] inArray = new Color[HEIGHT][WIDTH];
	        for (int x = 0; x < WIDTH; x++) {
	            for (int y = 0; y < HEIGHT; y++) {
	            	inArray[y][x] = in.getPixelReader().getColor(x, y);
	            }
	        }
			Color[][] outArray = parallelTransform(inArray);
			
			WritableImage out = new WritableImage(WIDTH, HEIGHT);
		        for (int x = 0; x < WIDTH; x++) {
		            for (int y = 0; y < HEIGHT; y++) {
		                out.getPixelWriter().setColor(x, y, outArray[y][x]);
		            }
		        }
		    return out;
		        
			
		}
		private Color[][] parallelTransform(Color[][] in)
		{
			int n = Runtime.getRuntime().availableProcessors();
			int height = in.length;
			int width = in[0].length;
			Color[][] out = new Color[height][width];
			try{
				ExecutorService pool = Executors.newCachedThreadPool();
				for(int i =0;i<n;i++){
					int fromY = i*height /n;
					int toY=(i+1)*height/n;
					pool.submit(()->{
						for(int x = 0;x<width;x++){
							for(int y = fromY;y<toY;y++){
								Color c = in[y][x];
								for (UnaryOperator<Color> f: pendingOperations){
									c = f.apply(c);
								}
								out[y][x] = c;
							}
						}
					});
				}
				pool.shutdown();
				pool.awaitTermination(1,TimeUnit.HOURS);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			return out;
		}
		
	}
}
