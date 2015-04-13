package java8_study.chapter2;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Question4 {
	public static void main( String[] args )
    {
		int[] values = {1,4,9,16};
		//int配列のストリームになる。要素数は１。
		Stream<int[]> vals = Stream.of(values);
    	System.out.println(vals.count());
    	
    	//
    	IntStream ints = IntStream.of(values);
    	System.out.println(ints.count());

    }
}
