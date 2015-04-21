package java8_study.chapter3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Question7 {

	public static void main( String[] args )
    {
		Comparator<String> comp = getComparator(true,false,true);
		
		String[] words = {"CC","dd","aa"};
		
		Arrays.sort(words,comp);
		
		for(String item : words){
			System.out.println(item);
		}
    }
	
	public static Comparator<String> getComparator(
			boolean isAsc,
			boolean caseSencitive,
			boolean includeSpace)
	{	
		return (String first,String second) -> {
			String firstStr = first;
			String secondStr = second;
			if(caseSencitive == false){
				firstStr = firstStr.toLowerCase();
				secondStr = secondStr.toLowerCase();
			}
			if(includeSpace == false){
				firstStr = firstStr.trim();
				secondStr = secondStr.trim();
			}
			if(isAsc == false){
				String temp = firstStr;
				firstStr = secondStr;
				secondStr = temp;
			}
			
			
			return firstStr.compareTo(secondStr);
			};
	}
}
