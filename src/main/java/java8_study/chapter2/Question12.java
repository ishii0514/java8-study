package java8_study.chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Question12 {
	public static void main( String[] args ) throws IOException
    {
		String alice = Question1.class.getClassLoader().getResource("./alice.txt").getFile();
    	//alice = alice.substring(1);
    	String contents = new String(Files.readAllBytes(Paths.get(alice)), StandardCharsets.UTF_8);
    	Stream<String> words = Arrays.asList(contents.split("[//P{L}]+")).stream();
    	
    	
    	AtomicInteger[] shortWords = new AtomicInteger[12];
    	Arrays.setAll(shortWords, n -> new AtomicInteger(0));
    	words.parallel().forEach(s -> {if(s.length() <12) shortWords[s.length()].getAndIncrement();});
    	
    	System.out.println(Arrays.toString(shortWords));
    	
    	
    	
    }
}
