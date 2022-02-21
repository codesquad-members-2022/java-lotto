package views;

import java.util.Scanner;

import static views.Output.println;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);
	public static final int PRICE_OF_ONE_LOTTO = 1000;
	public static final String OUTPUT_ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String OUTPUT_NUMBER_OF_PURCHASED = "개를 구매했습니다.";

	public Input() {
	}

	public static int getPurchaseAmount() {
		println.accept(OUTPUT_ASK_PURCHASE_AMOUNT);
		int purchaseAmount = nextInt();
		return purchaseAmount;
	}

	public static int getTicketAccount(int purchaseAmount) {
		int ticketAccount = purchaseAmount / PRICE_OF_ONE_LOTTO;
		println.accept(informPurchasing(ticketAccount));
		return ticketAccount;
	}

	private static String informPurchasing(int ticketAccount) {
		return ticketAccount + OUTPUT_NUMBER_OF_PURCHASED;
	}

	public static String nextLine() {
		return scanner.nextLine();
	}

	public static int nextInt() {
		return Integer.parseInt(nextLine());
	}

	public static void scanClose() {
		scanner.close();
	}
}
