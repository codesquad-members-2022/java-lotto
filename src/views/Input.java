package views;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;
import static views.Output.println;

public class Input {
	private static final Scanner scanner = new Scanner(System.in);
	public static final int PRICE_OF_ONE_LOTTO = 1000;
	public static final String OUTPUT_ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String OUTPUT_NUMBER_OF_PURCHASED = "개를 구매했습니다.";
	public static final String OUTPUT_ASK_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

	public Input() {
	}

	public static int getBonusNumber(){
		println.accept("보너스 볼을 입력해주세요.");
		int bonusNumber = nextInt();
		return bonusNumber;
	}

	public static List<Integer> inputWinningNumbers(){
		println.accept(OUTPUT_ASK_WINNING_NUMBER);
		String textNumbers = nextLine();
		List<Integer> winningNumbers = toInteger(textNumbers);
		return winningNumbers;
	}

	private static List<Integer> toInteger(String textNumbers) {
		return Arrays.stream(textNumbers.split(","))
				.map(Integer::parseInt)
				.collect(toList());
	}

	public static PurchasedLotto purchaseLotto() {
		int purchaseAmount = getPurchaseAmount();
		int numberOfTicket = getTicketAccount(purchaseAmount);
		return new PurchasedLotto(purchaseAmount, numberOfTicket);
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
