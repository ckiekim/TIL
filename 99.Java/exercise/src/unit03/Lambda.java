package unit03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Lambda {
	static final String HEX = "ff";
	public static void main(String[] args) {
		MyFunction f1 = new MyFunction() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		System.out.println(f1.max(2, 3));
		
		MyFunction f2 = (a, b) -> a > b ? a : b;
		System.out.println(f2.max(3, 4));
		
		List<String> list = new ArrayList<>(Arrays.asList("A quick brown fox".split(" ")));
		Collections.sort(list, (s1, s2)->s2.compareTo(s1));		// Comparator
		System.out.println(list);
		
		BiFunction<Integer, Integer, Integer> f3 = (a, b) -> a > b ? a : b;
		System.out.println(f3.apply(3, 4));
		BinaryOperator<Integer> f4 = (a, b) -> a > b ? a : b;
		System.out.println(f4.apply(3, 4));
		
		Function<String, Integer> f = s -> Integer.parseInt(s, 16);
		Function<Integer, String> g = i -> Integer.toBinaryString(i);
		Function<String, String> h = f.andThen(g);
		System.out.println(h.apply(HEX));
		
		BiPredicate<String, String> p = (s1, s2) -> Integer.parseInt(s1, 16)==(Integer.parseInt(s2, 2));
		System.out.println(p.test(HEX, h.apply(HEX)));
		
		list.removeIf(s -> s.length() == 1);
		System.out.println(list);
		
		List<Integer> il = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		System.out.println(il);
		il.removeIf(x -> (x%2 == 0));
		System.out.println(il);
	}
}

@FunctionalInterface
interface MyFunction {
	int max(int a, int b);		// public abstract 생략 가능
}