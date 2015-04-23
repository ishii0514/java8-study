package java8_study.chapter3;

import java.util.function.BiFunction;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Question11 {
	public static void main( String[] args )
    {
		Image image = new Image("http://yahoo.co.jp");
		int width = (int)image.getWidth();
		int height = (int)image.getHeight();
		
		Image TransformedImage = transform(image,compose(change(c->c.brighter()),
				(x,y,c) -> x < 10 || y < 10 || x >= width - 10 || y >= height - 10 ? Color.GRAY: c
		));
    }
	
	
	public static ColorTransformer compose(ColorTransformer first,ColorTransformer second){
		return (x,y,c) -> second.apply(x, y, first.apply(x, y, c));
	}
	
	public static ColorTransformer change(UnaryOperator<Color> u){
		return (x,y,c) -> u.apply(c);
	}
	
	public static <T> Image transform(Image in ,ColorTransformer c){
		int width = (int)in.getWidth();
		int height = (int)in.getHeight();
		WritableImage out = new WritableImage(width, height);
		for(int x =0;x< width; x++){
			for (int y = 0; y<height; y++){
				out.getPixelWriter().setColor(x,y,
						c.apply(x,y, in.getPixelReader().getColor(x,y)));
			}
		}
		return out;
	}
	
	@FunctionalInterface
	public static interface ColorTransformer{
		Color apply(int x, int y, Color colorAtXY);
		
	}
}
