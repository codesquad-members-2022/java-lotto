package application.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    private InputView() {

    }

    public static int getPurchaseAmount() {
        OutputView.printEnterPurchaseAmount();
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        OutputView.printPleaseEnterYourWinningNumber();
        return Arrays.stream(scanner.next().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
