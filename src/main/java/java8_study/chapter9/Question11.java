package java8_study.chapter9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UncheckedIOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question11 {
	public static void main(String[] args){
		
        String dir =".";
        String regex = "[0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4}";
        Pattern pattern = Pattern.compile("(.*):.*(" + regex + ")");

        final ProcessBuilder builder = new ProcessBuilder("grep", "-r", regex, dir);

        Process process;
        try {
            process = builder.start();
            process.waitFor();
        } catch (InterruptedException | IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            br.lines().forEach(line -> {
                    Matcher matcher = pattern.matcher(line);
                    if (matcher.matches()) {
                        System.out.println(matcher.group(1) + "," + matcher.group(2));
                    }
                }
            );
        } catch (IOException ioe) {
            throw new UncheckedIOException(ioe);
        }

        process.destroy();
    }
	
}
