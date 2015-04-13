package java8_study.chapter2;

import java.util.stream.Stream;

public class Question7 {
	public static void main( String[] args )
    {
		//途中
		
		Stream<String> words = Stream.of("aaa","bbb","cccc");
		inFinite(words);
		//words.forEach(System.out::println);
		Stream<String> words2 = Stream.generate(() -> "Echo");
		inFinite(words2);
		
    }
	public static <T> boolean inFinite(Stream<T> stream){
		System.out.println(stream.count());
		return true;
	}
}
