package exercise;

public class Hello {
	public static void main(String[] args) {
		Card kb = new Card(12345678,"2510","홍길동",345);
		System.out.println(kb);
		Card bc = new Card(12345678,"2510","제임스",123);
		System.out.println(bc);
		System.out.println(kb.equals(bc));

		String a = "aaa";
		String b = "aaa";
		System.out.println(b.hashCode());
	}

}
