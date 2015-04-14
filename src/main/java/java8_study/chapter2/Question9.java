package java8_study.chapter2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Question9 {
	public static void main( String[] args )
    {
		ArrayList<String> list1 = new ArrayList<String>();
		list1.add("aa");
		list1.add("bb");
		ArrayList<String> list2 = new ArrayList<String>();
		list2.add("01");
		list2.add("02");
		ArrayList<String> list3 = new ArrayList<String>();
		list3.add("AA");
		list3.add("BB");
		
		
		Stream<ArrayList<String>> s = Stream.of(list1,list2,list3);
		ArrayList<String> result = s.reduce(
				new ArrayList<String>(), 
				(first,second) -> {first.addAll(second);
									return first;},
				(first,second) -> {first.addAll(second);
									return first;}
				);
		
		System.out.println(result);
    }
	
}
