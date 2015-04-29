package java8_study.chapter3;

import java.util.function.BiFunction;
import java.util.function.Function;

/*
map
T->Uを適用する。具体的には以下の形になる。
G<U> flatMap(Function<? super T, ? super T, U> mapper)

flatmap
T−＞G<U>を適用する。具体的には以下の形になる。
G<U> flatMap(Function<? super T, ? super T, G<U>> mapper)

*/
public class Question24 {

	public static void main( String[] args )
    {
		
    }
	public static class Pair<T> {

	    private T left;
	    private T right;

	    public Pair(T left, T right) {
	        this.left = left;
	       this.right = right;
	    }
	    //BiFunctionをとれば、可能。Pair<T>の要素が２つなので、２つ消費する形が必要。
	    //だが、一般的なflatmapではない。
	    public <U> Pair<U> flatMap(BiFunction<? super T, ? super T, Pair<U>> mapper) {
	        return mapper.apply(this.left, this.right);
	    }
	    
	    //Functionでは不可。
	    //一つしか要素を消費しないので結果の数が合わなくなる。
	    public <U> Pair<U> flatMap(Function<? super T, Pair<U>> mapper) {
	    	Pair<U> leftPair = mapper.apply(this.left);
	    	Pair<U> rightPair = mapper.apply(this.right);
	    	return null;
	    }
	}
}
