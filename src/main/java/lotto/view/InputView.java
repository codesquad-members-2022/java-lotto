package lotto.view;

import java.util.Scanner;

public class InputView {
    private static Scanner sc;
    private static String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return sc.nextInt();
    }

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }
}
