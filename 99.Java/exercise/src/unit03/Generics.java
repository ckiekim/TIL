/**
 * Javadoc을 위한 주석입니다.
 */
package unit03;

import java.util.ArrayList;
import java.util.List;
import unit02.Person;

enum Direction {EAST, WEST, SOUTH, NORTH};

public class Generics {

	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();
		list.add(10); list.add(20);
		list.add("30");
		System.out.println(list);
		
		List<Person> pl = new ArrayList<>();
		pl.add(new Person("Maria", 25));
		pl.add(new Person("James", 23));
		pl.add(new Person("Brian", 33));
		pl.add(new Person("Anne", 23));
		pl.sort(null);
		System.out.println(pl);
		
		Direction d1 = Direction.EAST;
		Direction d2 = Direction.WEST;
		System.out.println((d1 == d2) ? Direction.valueOf("EAST") : "not EAST");
		System.out.println((d1.equals(d2)) ? Direction.EAST : "not EAST");
		System.out.println(d1.compareTo(d2));
		for (Direction d: Direction.values())
			System.out.printf("%s = %d%n", d.name(), d.ordinal());
	}
}
