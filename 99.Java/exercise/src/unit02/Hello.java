package unit02;

public class Hello {
	private static final String XYZ = "abc";
	private static final int ABC = 1234;
	public static void main(String[] args) {
		Card[] cards = new Card[3];
		Card kb = new Card(12345678,"2510","홍길동",345);
		Card bc = new Card(12345678,"2510","제임스",123);
		System.out.println(kb.equals(bc));
		cards[0] = kb;
		cards[1] = bc;
		cards[2] = new Card(34567890,"2602","마리아",789);
		if (cards[cards.length-1] == (Card)null) {
			System.out.println("null");
		} else {
			System.out.println("not null");
		}
		printCard(cards);

		String a = XYZ;
		String b = XYZ;
		System.out.println(a.hashCode() + ", " + b.hashCode());
		System.out.println(a.toCharArray()[2]);
		
		String[] str = "James, Maria. Kevin, Anne".split("[,.] ");
		for (int i=0; i<str.length; i++)
			str[i] = str[i].trim();
		System.out.println(String.join(" - ", str));
		
		StringBuilder sb = new StringBuilder(16);
		for (String s: str)
			sb.append(s.trim());
		System.out.println(sb);
		System.out.println(sb.length());
		
		System.out.println(Math.round(Math.PI * 100000) / 100000.);
		int i = Integer.parseInt("ff",16);
		System.out.println(i);
	}

	private static void printCard(Card[] cards) {
		for (Card card : cards) {
			card.setCvc(card.getCvc()+1);
			System.out.println(card);
		}
	}
}
