package application.view;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import application.domain.Lotto;
import application.model.Validation;

public class InputView {

    private static Validation validation = new Validation();
    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int getBonusBall(Lotto winningNumber) {
        OutputView.printEnterBonusBall();
        int bonusBall = scanner.nextInt();
        while (!validation.validateBonusBallNumberRange(bonusBall, winningNumber)) {
            OutputView.printInvalidFormatPleaseReEnter();
            bonusBall = scanner.nextInt();
        }
        return bonusBall;
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
                OutputView.printInvalidFormatPleaseReEnter();
                removeNewLine();
            }
        }
    }

    public static List<Integer> getWinningNumber() {
        OutputView.printPleaseEnterYourWinningNumber();
        String winningNumberString = scanner.nextLine();
        while (!validation.validateLottoString(winningNumberString)) {
            OutputView.printInvalidFormatPleaseReEnter();
            winningNumberString = scanner.nextLine();
        }
        return stringConversion(winningNumberString);
    }

    public static int getNumberOfManualLotto(int money) {
        OutputView.printEnterNumberOfManualLotto();
        int numberOfManualLotto = scanner.nextInt();
        while (!validation.validateNumberOfManualLotto(numberOfManualLotto, money)) {
            OutputView.printInvalidFormatPleaseReEnter();
            numberOfManualLotto = scanner.nextInt();
        }
        return numberOfManualLotto;
    }

    public static List<Integer> getManualLotto() {
        String manualLottoString = scanner.nextLine();
        while (!validation.validateLottoString(manualLottoString)) {
            OutputView.printInvalidFormatPleaseReEnter();
            manualLottoString = scanner.nextLine();
        }
        return stringConversion(manualLottoString);
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
