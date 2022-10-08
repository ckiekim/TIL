package unit02;
import java.util.Objects;

public class Card {
	private int number;
	private String expDate;
	private String owner;
	private int cvc;
	public Card(int number, String expDate, String owner, int cvc) {
		super();
		this.number = number;
		this.expDate = expDate;
		this.owner = owner;
		this.cvc = cvc;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public int getCvc() {
		return cvc;
	}
	public void setCvc(int cvc) {
		this.cvc = cvc;
	}
	@Override
	public String toString() {
		return "Card [number=" + number + ", expDate=" + expDate + ", owner=" + owner + ", cvc=" + cvc + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(expDate, number);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return Objects.equals(expDate, other.expDate) && number == other.number;
	}
}
