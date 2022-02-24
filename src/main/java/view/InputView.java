package view;

import java.util.Scanner;

import utils.InputValidator;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);

    public static String requestPrice() {
        String price;
        while (true) {
            price = nextLine();
            try {
                InputValidator.validateNumber(price);
                return price;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
    }

    public static String requestWinNumber() {
        return nextLine();
    }

    public static String requestBonusNumber() {
        String bonusNumber;
        while (true) {
            bonusNumber = nextLine();
            try {
                InputValidator.validateNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
    }

    public static String requestManualCount() {
        String count;
        while (true) {
            count = nextLine();
            try {
                InputValidator.validateNumber(count);
                return count;
            } catch (IllegalArgumentException e) {
                OutputView.printSentence(e.getMessage());
            }
        }
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
