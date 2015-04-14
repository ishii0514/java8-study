package java8_study.chapter2;

import java.util.stream.Stream;

public class Question10 {
	public static void main( String[] args )
    {
		Stream<Double> d = Stream.of(12.5d, 11.5d, 13.5d);
		double[] result =  d.reduce(new double[3],
				(r,s) -> {
					r[0] += s.doubleValue();
					r[1] += 1.0;
					r[2] = r[0] /r[1];
					return r;
				},
				(r,s) -> {
					r[0] += s[0];
					r[1] += s[1];
					r[2] = r[0] /r[1];
					return r;
				}
				);
		System.out.println(result[2]);
		
    }
	
}
