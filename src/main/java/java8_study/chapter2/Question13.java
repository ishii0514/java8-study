package java8_study.chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Question13 {
	public static void main( String[] args ) throws IOException
    {
		String alice = Question1.class.getClassLoader().getResource("./alice.txt").getFile();
		//alice = alice.substring(1);
		String contents = new String(Files.readAllBytes(Paths.get(alice)), StandardCharsets.UTF_8);
		Stream<String> words = Arrays.asList(contents.split("[//P{L}]+")).stream();
		
		Map<Integer, Long> wordsMap = words.parallel()
			    .filter(s -> s.length() < 12)
			    .collect(Collectors.groupingBy(String::length, Collectors.counting()));
		
		for (int n = 0; n < 12; n++) {
		    System.out.print(wordsMap.get(n));
		    System.out.print(", ");
		}

    }
}
