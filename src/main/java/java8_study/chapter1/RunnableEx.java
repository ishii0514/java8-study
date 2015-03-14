package java8_study.chapter1;

@FunctionalInterface
public interface RunnableEx {
	public void run() throws Exception;
	
	public static Runnable uncheck(RunnableEx runner)
	{
		return () -> {
			try {
				runner.run();
			} catch(Exception e){
				throw new RuntimeException();
			}
		};
	}
	

}
