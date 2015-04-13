package java8_study.chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutionException;
import java.util.stream.Stream;

public class Question2 {
	public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
    	String alice = Question1.class.getClassLoader().getResource("./alice.txt").getFile();
    	//alice = alice.substring(1);
    	String contents = new String(Files.readAllBytes(Paths.get(alice)), StandardCharsets.UTF_8);
    	Stream<String> words = Stream.of(contents.split("[//P{L}]+"));
    	
    	Object[] result = words.filter(s -> s.length() > 12).peek(e->System.out.println("fetching :"+e)).limit(5).toArray();
    	
    	
    	

    }
}
