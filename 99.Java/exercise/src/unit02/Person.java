package unit02;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable {
	String name;
	int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Object o) {
		if (o instanceof Person) {
			Person p = (Person)o;
			if (this.age != p.age)
				return this.age - p.age;
			return this.name.compareToIgnoreCase(p.name);
		}
		return -1;
	}
}
