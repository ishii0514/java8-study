package java8_study.chapter1;

import java.util.ArrayList;
import java.util.List;


public class Question8 {
	public static void main( String[] args )
    {
		String[] names = {"Peter", "Paul", "Mary"};

		//enhanced for roop
		List<Runnable> runners = new ArrayList<>();
		for (String name : names){
			runners.add(()->System.out.println(name));
		}
		execute(runners);

		//for roop
		List<Runnable> runners2 = new ArrayList<>();
		for (int i=0; i < names.length; i++){
			//compile error: Local variable i defined in an enclosing scope must be final or effectively final
			//runners2.add(()->System.out.println(names[i]));

			//ok
			String name = names[i];
			runners2.add(()->System.out.println(name));
		}
		execute(runners2);

    }

	private static void execute(List<Runnable> runners){
		for (Runnable runner : runners){
			new Thread(runner).start();
		}
	}
}
