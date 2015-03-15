package java8_study.chapter1;

public class Question7 {
	public static void main( String[] args )
    {
		
		new Thread(andThen(
				()->System.out.println("first"),
				()->System.out.println("second")
				)).start();
    }
	
	public static Runnable andThen(Runnable first, Runnable second){
		return ()->{
			first.run();
			second.run();};
	}
}
