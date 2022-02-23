package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String requestPrice() {
        OutputView.requestPrice();
        return sc.nextLine();
    }

    public static String requestWinNumber() {
        OutputView.requestWinNumber();
        return sc.nextLine();
    }

    public static String requestBonusNumber() {
        OutputView.requestBonusNumber();
        return sc.nextLine();
    }

    public static String requestManual() {
        OutputView.requestManual();
        return sc.nextLine();

    }

    // TODO
    public static void scannerClose() {

        sc.close();
    }

    public static String requestManualLottoNumber(int count) {
        return sc.nextLine();
    }
}
