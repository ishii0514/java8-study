package java8_study.chapter1;

import java8_study.chapter1.RunnableEx;

public class Question6 {
	public static void main( String[] args )
    {
		new Thread(RunnableEx.uncheck(() -> {
		    System.out.println("Zzz");
		    Thread.sleep(1000);
		})).start();
    }
}
