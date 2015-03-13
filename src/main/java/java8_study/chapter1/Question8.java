package java8_study.chapter1;

import java.util.ArrayList;
import java.util.List;


public class Question8 {
	public static void main( String[] args )
    {
		String[] names = {"Peter", "Paul", "Mary"};
		List<Runnable> runners = new ArrayList<>();
		for (String name : names){
			runners.add(()->System.out.println(name));
		}
		for (Runnable runner : runners){
			//runner.run();
			new Thread(runner).start();
		}
		
		List<Runnable> runners2 = new ArrayList<>();
		for (int i=0; i < names.length; i++){
			//runners2.add(()->System.out.println(names[i]));	//<-Local variable i defined in an enclosing scope must be final or effectively final
			String name = names[i];
			runners2.add(()->System.out.println(name));	//<-OK
		}
		
		for (Runnable runner : runners2){
			new Thread(runner).start();
		}
		
		
    }
}
