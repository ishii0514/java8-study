package java8_study.chapter1;

public class Closure {
	public static void main( String[] args )
    {
		String name = "ishii";
		int counter = 0;
		Runnable runner = ()->{
			//counter += 1;		//外部変数を変更するようなラムダ式はエラーになる。
			System.out.println(counter);};
		new Thread(runner).start();
		
    }
}
