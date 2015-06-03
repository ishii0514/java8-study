package java8_study.chapter8;

import java.util.Random;

public class Question4 {
	public static double a = 11d;
	public static double m = 25214903917d;
	public static double n = Math.pow(2,48);
	public static double v = 246154705703781d;
	
	public static void main(String[] args){
		Random generator = new Random(164311266871034L);
		//System.out.println(Double.toString(generator.nextDouble()));
		//System.out.println(Double.toString(generator.nextDouble()));
		//System.out.println(Double.toString(generator.nextDouble()));
		
		int count = 5;
		double s = 0d;
		for(int i = 0; i < count;i++){
			s= prev(s);
			System.out.println(Double.toString(s));
		}
	}
	
	public static double prev(double seed){
		double f = (seed -a) * v;
		return (double)Math.floorMod((long)f, (long)n);
	}
}
