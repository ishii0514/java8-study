package java8_study.chapter1;

import java.util.Arrays;
import java.util.Random;

/**
 * Hello world!
 *
 */

//http://closedunbounded.hatenablog.com/entry/2015/01/10/153146

public class Question1
{
    public static void main( String[] args )
    {
    	String[] array = new String[16*1024];
    	Random random = new Random();
    	for (int i = 0; i < array.length; i++) {
    	    array[i] = Double.toString(random.nextDouble());
    	}
    	long threadID = Thread.currentThread().getId();
    	System.out.println("Main Thread is " + threadID);
    	Arrays.sort(array, (first, second) -> {
    	    if (Thread.currentThread().getId() != threadID) {
    	        System.out.println("Comparator Thread is " + Thread.currentThread().getId());
    	    }
    	    return first.compareToIgnoreCase(second);
    	});
    	//System.out.println(Arrays.toString(array));
    }
    
    
}
