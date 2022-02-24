package views;

public class PurchasedLotto {
	private final int purchaseAmount;
	private final int numberOfTicket;

	public PurchasedLotto(int purchaseAmount, int numberOfTicket) {
		this.purchaseAmount = purchaseAmount;
		this.numberOfTicket = numberOfTicket;
	}

	public int getPurchaseAmount() {
		return purchaseAmount;
	}

	public int getNumberOfTicket() {
		return numberOfTicket;
	}
}
