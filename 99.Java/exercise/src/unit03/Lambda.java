package unit03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lambda {

	public static void main(String[] args) {
		MyFunction f1 = new MyFunction() {
			public int max(int a, int b) {
				return a > b ? a : b;
			}
		};
		System.out.println(f1.max(2, 3));
		
		MyFunction f2 = (a, b) -> a > b ? a : b;
		System.out.println(f2.max(3, 4));
		
		List<String> list = Arrays.asList("A", "quick", "brown", "fox");
		Collections.sort(list, (s1, s2)->s2.compareTo(s1));		// Comparator
		System.out.println(list);
	}
}

@FunctionalInterface
interface MyFunction {
	int max(int a, int b);		// public abstract 생략 가능
}