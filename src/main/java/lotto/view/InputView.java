package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String REQUIRED_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";


    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        int purchaseAmount = sc.nextInt();
        sc.nextLine();

        return purchaseAmount;
    }

    public static int getManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_MESSAGE);
        int manualLottoCount = sc.nextInt();
        sc.nextLine();

        return manualLottoCount;
    }

    public static String getManualLottoNumbers() {
        System.out.println(MANUAL_LOTTO_NUMBERS_MESSAGE);
        return sc.nextLine();
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
