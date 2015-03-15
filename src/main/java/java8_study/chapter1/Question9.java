package java8_study.chapter1;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Question9 {
	interface Cllection2<T> extends Collection<T>{
		default void forEarchIf(Consumer<T> action, Predicate<T> filter){
			forEach((T t)->{
				if(filter.test(t)){
					action.accept(t);
				}
			});
		}
	}
}
