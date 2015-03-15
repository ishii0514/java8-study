package java8_study.chapter1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java8_study.chapter1.RunnableEx;

public class Question6 {

	public static void main( String[] args )
    {
		new Thread(RunnableEx.uncheck(() -> {
		    System.out.println("Zzz");
		    Thread.sleep(1000);
		    System.out.println("Zzz!");
		})).start();
		
		//Callable<void>を利用
		ExecutorService exec = Executors.newSingleThreadExecutor();
		exec.submit(() -> {
		    System.out.println("callable-Zzz");
		    Thread.sleep(1000);
		    System.out.println("callable-Zzz!");
		    return null;
		});
		
    }
}
