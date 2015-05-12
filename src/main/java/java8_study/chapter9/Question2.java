package java8_study.chapter9;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class Question2 {
	public static void main(String[] args){
        try {
            excute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void excute() throws Exception{
        Scanner in = null;
        try {
            in = new Scanner(Paths.get("/in.txt"));
        } catch (IOException e) {
            throw e;
        }

        PrintWriter out = null;
        try {
            out = new PrintWriter("/out.txt");
        } catch (FileNotFoundException e) {
        	try {
                close(in);
            } catch (IOException ex) {
                e.addSuppressed(ex);
            }
            throw e;
        }

        try {
            while (in.hasNext()) {
                out.println(in.next().toLowerCase());
            }
        } catch (Exception e) {
        	try {
                close(in, out);
            } catch (IOException ex) {
                e.addSuppressed(ex);
            }
            throw e;
        }

        close(in, out);

    }

    private static void close(final Closeable in, final Closeable out) throws IOException{
        try {
            close(in);
        }catch(Exception e){
        	try {
                close(out);
            } catch (IOException ex) {
                e.addSuppressed(ex);
            }
            throw e;
        }
        close(out);
    }

    private static void close(final Closeable resource) throws IOException{
        resource.close();
    }
}
