package java8_study.chapter3;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Comparator;

public class Question9 {
	public static void main( String[] args )
    {	
		Person[] persons = {new Person("ishii","aasuke"), new Person("ishii","junpei"),new Person("abe","yosuke")};
		

		Arrays.sort(persons,lexicograficComparator("lastName","firstName"));
		
		for(Person person : persons){
			System.out.println(person.lastName + "," + person.firstName);
		}
    }
	
	public static <T> Comparator<T> lexicograficComparator(String... fieldNames)
	{	
		return (T first, T second) ->{
			Class<?> c = first.getClass();
			for (String fieldName : fieldNames){
				Field f1 = null;
				String m1 = "";
				String m2 = "";
				try {
					f1 = c.getDeclaredField(fieldName);
					m1 = (String) f1.get(first);
					m2 = (String) f1.get(second);
				} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				int comp = m1.compareTo(m2);
				if (comp != 0){
					return comp;
				}
			}
			return 0;
			};
	}
	
	public static class Person{
		public String lastName = "";
		public String firstName = "";
		public Person(String lastName,String firstName){
			this.lastName = lastName;
			this.firstName = firstName;
		}
	}
}
