package java8_study.chapter1;

import java.io.File;

public class Question2 {
	public static void main( String[] args )
    {
		File f = new File("/Users/ishii0514");
		
		for (File item : lambda(f)){
			System.out.println(item.getName());
		}
		System.out.println("-------------------------");
		for (File item : methodref(f)){
			System.out.println(item.getName());
		}
		
    }
	
    private static File[] lambda(File f){
    	File[] files = f.listFiles((x) ->x.isDirectory());
    	return files;
    }
    
    private static File[] methodref(File f){
    	File[] files = f.listFiles(File::isDirectory);
    	return files;
    }
}
