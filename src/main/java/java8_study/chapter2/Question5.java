package java8_study.chapter2;

import java.util.stream.Stream;

public class Question5 {
	public static void main( String[] args )
    {
		Long seed = 0L;
		Long a = 25214903917L;
		Long c = 11L;
		Long m = (long) Math.pow(2,48);
		
		Stream<Long> random = Stream.iterate(seed, n -> (a*n+c) % m);
		random.limit(5).forEach(e -> System.out.println(e));
    }
}
