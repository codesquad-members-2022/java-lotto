package application.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int getBonusBall() {
        OutputView.printEnterBonusBall();
        return scanner.nextInt();
    }

    public static int getPurchaseAmount() {
        OutputView.printEnterPurchaseAmount();
        return scanner.nextInt();
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
