package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static int purchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String winningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

    public static String bonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return scanner.nextLine();
    }
}
