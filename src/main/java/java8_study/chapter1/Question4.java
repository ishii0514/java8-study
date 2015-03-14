package java8_study.chapter1;

import java.io.File;
import java.util.Arrays;

public class Question4 {
	public static void main( String[] args )
    {
		File[] files = new File("/Users/ishii0514").listFiles();
		
		System.out.println("---------before------");
		for(File file:files)
			System.out.println(file.getName() +":"+ file.isDirectory());
		
		
		Arrays.sort(files,(first,second)-> {
			if (first.isDirectory() == second.isDirectory()) {
				return first.getPath().compareTo(second.getPath());
			} else if(first.isDirectory()){
				return -1;
			}
			return 1;
			});
		
		System.out.println("---------after------");
		for(File file:files)
			System.out.println(file.getName() +":"+ file.isDirectory());
		
    }

}
