package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;
    private static String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static String REQUIRED_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        int purchaseAmount = sc.nextInt();
        sc.nextLine();

        return purchaseAmount;
    }

    public static String getRequiredWinningNumber() {
        System.out.println(REQUIRED_WINNING_NUMBER_MESSAGE);
        return sc.nextLine();
    }

    public static String getBonusBallNumber() {
        System.out.println(BONUS_BALL_NUMBER_MESSAGE);
        return sc.nextLine();
    }

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }
}
