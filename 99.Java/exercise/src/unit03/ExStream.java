package unit03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ExStream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Stream<Integer> intStream = list.stream();
		
		Iterator<Integer> it = intStream.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		list.forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		List<Integer> ranList = new ArrayList<>(10);
		for (int i=0; i<10; i++)
			ranList.add((int)(Math.random()*90) + 10);
		System.out.println(ranList);
		
		Stream<Integer> ran = ranList.stream();
		ran.forEach(x -> System.out.print(x+" "));
		System.out.println();
		ran = ranList.stream();
		ran.distinct().sorted().limit(5).forEach(System.out::println);
		
		IntStream lotto = new Random().ints(1,46);
		lotto.distinct().limit(6).sorted().forEach(x -> System.out.print(x+" "));
		System.out.println();
		
		Stream<String> strStream = Stream.of("A quick brown fox".split(" "));
		strStream.sorted().forEach(System.out::println);
	}

}
