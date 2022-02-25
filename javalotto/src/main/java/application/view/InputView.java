package application.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.model.Validation;

public class InputView {

    private static Validation validation = new Validation();
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int getBonusBall() {
        OutputView.printEnterBonusBall();
        return scanner.nextInt();
    }


    public static int getPurchaseAmount() {
        while (true) {
            OutputView.printEnterPurchaseAmount();
            try {
                int purchaseAmount = scanner.nextInt();
                if (validation.validatePurchaseAmount(purchaseAmount)) {
                    return purchaseAmount;
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
                removeNewLine();
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        OutputView.printPleaseEnterYourWinningNumber();
        return stringConversion(scanner.nextLine());
    }

    public static int getNumberOfManualLotto() {
        OutputView.printEnterNumberOfManualLotto();
        return scanner.nextInt();
    }

    public static List<Integer> getManualLotto() {
        List<Integer> lotto = stringConversion(scanner.nextLine());
        return lotto;
    }

    private static List<Integer> stringConversion(String lottoString) {
        return Stream.of(lottoString.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void removeNewLine() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
