package java8_study.chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Qustion1 {
    public static void main( String[] args ) throws IOException
    {
    	String alince = "/Users/ishii0514/dev/workspace/java8-study/src/main/resources/alice.txt";
    	String contents = new String(Files.readAllBytes(Paths.get(alince)), StandardCharsets.UTF_8);
    	List<String> words = Arrays.asList(contents.split("[//P{L}]+"));
    	
    	int count = 0;
    	for (String w:words){
    		if (w.length() > 12) count++;
    	}
    	System.out.println("count=" + Integer.toString(count));
    	
    }
}
