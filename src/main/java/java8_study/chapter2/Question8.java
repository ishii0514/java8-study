package java8_study.chapter2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


public class Question8 {
	public static void main( String[] args )
    {
		
		Stream<String> first = Stream.of("aa","bb");
		Stream<String> second = Stream.of("00","01","02");
		
		zip(first, second).forEach(System.out::println);
		
    }
	public static <T> Stream<T> zip(Stream<T> first, Stream<T> second)
	{		
		Iterator<T> firstIt = first.iterator();
		Iterator<T> secondIt = second.iterator();
		
		List<T> zipping = new ArrayList<T>();
		
		while(firstIt.hasNext() && secondIt.hasNext()){
			zipping.add(firstIt.next());
			zipping.add(secondIt.next());
		}

		return zipping.stream();
	}
}
