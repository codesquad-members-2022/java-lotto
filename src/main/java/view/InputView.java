package view;

import java.util.Scanner;

import utils.InputValidator;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String requestPrice() {
        OutputView.requestPrice();
        String price;
        while (true) {
            price = nextLine();
            try {
                InputValidator.validatePrice(price);
                return price;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
    }

    public static String requestWinNumber() {
        OutputView.requestWinNumber();
        return nextLine();
    }

    public static String requestBonusNumber() {
        OutputView.requestBonusNumber();
        return nextLine();
    }

    public static String requestManual() {
        OutputView.requestManual();
        return nextLine();

    }

    public static String requestManualLottoNumber() {
        return nextLine();
    }

    private static String nextLine() {
        return sc.nextLine();
    }

    public static void scannerClose() {
        sc.close();
    }
}
