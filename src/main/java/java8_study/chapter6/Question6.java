package java8_study.chapter6;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class Question6 {
	public static void main( String[] args )
    {
		String targetDir = Question6.class.getClassLoader().getResource("./").getFile();
		targetDir = targetDir.substring(1);
		File dir = new File(targetDir);
	    File[] files = dir.listFiles();

		ConcurrentHashMap<String, Set<File>> map = getWords(files);



    }
	public static ConcurrentHashMap<String, Set<File>> getWords(File[] targetFiles)
	{
		ConcurrentHashMap<String, Set<File>> map = new ConcurrentHashMap<String, Set<File>>();


		int thread_number = targetFiles.length;
		ExecutorService pool = Executors.newFixedThreadPool(thread_number);
		List<Future<Integer>> futures = new ArrayList<>();


		for(int i=0;i<targetFiles.length;i++){
			File targetFile = targetFiles[i];
			Future<Integer> future = pool.submit(()
					->{  try {
							String contents = new String(Files.readAllBytes(Paths.get(targetFile.getAbsolutePath())), StandardCharsets.UTF_8);
							List<String> words = Arrays.asList(contents.split("[//P{L}]+"));
							for(String word:words){
								map.computeIfAbsent(word, k ->  new ConcurrentSkipListSet<File>()).add(targetFile);
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						return 0;
					}
						);

			futures.add(future);
		}
		for (Future<Integer> future : futures) {
			try {
				future.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		pool.shutdown();
		return map;
	}
}
