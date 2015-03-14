package java8_study.chapter1;

import java.io.File;

public class Question3 {
	public static void main( String[] args )
    {
		File f = new File("/Users/ishii0514");
		String ext = "log";
		
		//キャプチャされる変数 = ext
		String[] files = f.list((dir,name)->name.endsWith("." + ext));
		for (String item : files ){
			System.out.println(item);
		}
    }
}
