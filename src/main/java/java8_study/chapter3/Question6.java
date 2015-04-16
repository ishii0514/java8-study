package java8_study.chapter3;

import java.util.function.BiFunction;

import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;


public class Question6 {
	public static void main( String[] args )
    {
		Image image = new Image("http://yahoo.co.jp");
		Image brightendImage = transform(
				image,
				(c, factor) -> c.deriveColor(0,1,factor,1),
				1.2
				);
		
    }
	public static <T> Image transform(Image in ,BiFunction<Color,T,Color> f, T arg){
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0;x< width; x++){
			for (int y = 0; y<height; y++){
				out.getPixelWriter().setColor(x,y,
						f.apply(in.getPixelReader().getColor(x,y), arg));
			}
		}
		return out;
	}
}
