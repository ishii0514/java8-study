package java8_study.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question6 {
	public static void main( String[] args )
    {
		Stream<Character> s = characterStream("abcd");
		s.forEach(System.out::println);
		
    }
	
	public static Stream<Character> characterStream(String s){
		return IntStream.range(0, s.length()).mapToObj(s::charAt);
		//List<Character> result = new ArrayList<>();
		//for(char c: s.toCharArray()){
		//	result.add(c);
		//}
		//return result.stream();
	}
}
