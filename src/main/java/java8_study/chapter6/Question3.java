package java8_study.chapter6;


import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Supplier;

public class Question3 {
	public static final int THREAD_NUMBER = 1000;
	public static final int COUNT_NUMBER = 100000;


	public static void main(String[] args){
		System.out.println("-- use AtomicLong --------");
		AtomicLong counter = new  AtomicLong(0);
		getPerf(() ->{
		    	for(int j=0;j<COUNT_NUMBER;j++){
		    		counter.incrementAndGet();
		    	}
		    	return 0L;
		    },
		    () -> counter.get()
		    );
		System.out.println("-- use LongAdder --------");
		LongAdder counterAdder = new  LongAdder();
		getPerf(() ->{
		    	for(int j=0;j<COUNT_NUMBER;j++){
		    		counterAdder.increment();
		    	}
		    	return 0L;
		    },
		    () -> counterAdder.sum()
		    );

	}
	public static void getPerf(Callable<Long> callable,Supplier<Long> supplier){
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_NUMBER);
		List<Future<Long>> futures = new ArrayList<>();

		Instant start1 = Instant.now();
		for (int i = 0; i < THREAD_NUMBER; i++) {
			Future<Long> future = pool.submit(callable);
			futures.add(future);
		}

		Instant start2 = Instant.now();

		for (Future<Long> future : futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}

		Instant start3 = Instant.now();
		long result = supplier.get();
		Instant end = Instant.now();


		Duration sumbitTime = Duration.between(start1, start2);
		Duration executeTime = Duration.between(start2, start3);
		Duration sumTime = Duration.between(start3, end);
		Duration totalTime = Duration.between(start1, end);

		System.out.println("result:" + Long.toString(result));
		System.out.println("submit:" + Long.toString(sumbitTime.toMillis()));
		System.out.println("execute:" + Long.toString(executeTime.toMillis()));
		System.out.println("sum:" + Long.toString(sumTime.toMillis()));
		System.out.println("total:" + Long.toString(totalTime.toMillis()));

		pool.shutdown();
	}
}
