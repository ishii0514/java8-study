package java8_study.chapter3;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Question16 {
	public static void main( String[] args )
    {
		
    }
	public static <T> void doInOrderAsync(
			Supplier<T> first,
			BiConsumer<T,Throwable> second)
	{
		Thread t= new Thread(){
			public void run(){
				try{
					T result = first.get();
					second.accept(result, null);
				}catch(Throwable t){
					second.accept(null, t);
				}
			}
		};
		t.start();
		
	}
}
