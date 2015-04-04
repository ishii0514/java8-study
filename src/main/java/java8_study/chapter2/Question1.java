package java8_study.chapter2;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

//http://closedunbounded.hatenablog.com/entry/2015/01/19/132455
public class Question1 {
	public static void main( String[] args ) throws IOException, InterruptedException, ExecutionException
    {
    	String alice = Question1.class.getClassLoader().getResource("./alice.txt").getFile();
    	//alice = alice.substring(1);
    	String contents = new String(Files.readAllBytes(Paths.get(alice)), StandardCharsets.UTF_8);
    	List<String> words = Arrays.asList(contents.split("[//P{L}]+"));
    	
    	
    	int count = 0;
    	for (String w:words){
    		if (w.length() > 12) count++;
    	}
    	System.out.println("no thread count=" + Integer.toString(count));
    	
    	
    	int threadCount = 100;
    	int wordCount = words.size();
    	Object[] futures = new Object[wordCount];
    	ExecutorService exec = Executors.newFixedThreadPool(threadCount);
    	for (int i=0;i < wordCount;i++){
    		String w = words.get(i);
    		futures[i] = exec.submit(() -> {
    			if(w.length() > 12) return 1;
    			return 0;
    		});
    	}
    	
    	AtomicInteger atmicCount = new AtomicInteger();
    	for (int i=0;i < wordCount;i++){
    		@SuppressWarnings("unchecked")
			Future<Integer> future = (Future<Integer>)futures[i];
    		atmicCount.addAndGet(future.get());
    	}
    	System.out.println("thread count=" + atmicCount.toString());

    }
	
	
}

