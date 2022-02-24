package domains.users;

public class Money {
	private static final String WON = "원";
	private final int amount;

	public Money(int amount) {
		this.amount = amount;
	}

	public static Money of(int amount) {
		Money money = new Money(amount);
		return money;
	}

	public int amount() {
		return amount;
	}

	public String text() {
		return amount+WON;
	}
}
