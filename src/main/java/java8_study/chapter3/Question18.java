package java8_study.chapter3;

import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;


public class Question18 {
	public static void main( String[] args )
    {
		//Supplier<String> s = uncheckedSupplier(() -> new String("xxx"));

		Function<String,Boolean> f = uncheckedFunction((String s) -> {
				if (s.equals("yy")){
					throw new Exception("illgal parameter.");
				}
				return s.equals("xx");
				}
		);

		String x = "xx";
		System.out.println(f.apply(x));
    }

	public static <T> Supplier<T> uncheckedSupplier(Callable<T> f){
		return () -> {
			try{
				return f.call();
			}catch(Exception e){
				throw new RuntimeException(e);
			}catch(Throwable t){
				throw t;
			}
		};
	}

	public static <T,U> Function<T,U> uncheckedFunction(CallableWithParam<T,U> f){
		return (x) -> {
			try{
				return f.call(x);
			}catch(Exception e){
				throw new RuntimeException(e);
			}catch(Throwable t){
				throw t;
			}

		};
	}

	@FunctionalInterface
	public static interface CallableWithParam<T,R>{
		R call(T t) throws Exception;
	}
}
