package java8_study.chapter3;

import java.util.function.UnaryOperator;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;

public class Question10 {
	public static void main( String[] args )
    {
		UnaryOperator<Color> op = c -> c.brighter();	//Color::brighter
		
		Image image = new Image("http://yahoo.co.jp");
		//Image finalImage = transform(image, op.compose(Color::grayscale));
		// composeが返すのはFunctionインターフェースなので呼び出せない。
		//Image finalImage = transform(image, op.compose(c -> c.grayscale()));
		
    }
	
	public static Image transform(Image in, UnaryOperator<Color> f){
		return null;
	}
}
