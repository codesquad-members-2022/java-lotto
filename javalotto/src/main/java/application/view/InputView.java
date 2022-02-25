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
        removeNewLine();
        OutputView.printPleaseEnterYourWinningNumber();
        return stringConversion();
    }

    private static List<Integer> stringConversion() {
        return Stream.of(scanner.nextLine().split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void removeNewLine() {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
}
