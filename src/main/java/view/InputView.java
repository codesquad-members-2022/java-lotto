package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String ASK_PURCHASING_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요.";

    private Scanner scanner = new Scanner(System.in);

    public int getPurchasingAmount() {
        System.out.println(ASK_PURCHASING_AMOUNT);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }

    public List<Integer> getWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER_MESSAGE);
        String winningValue = scanner.nextLine();
        return Arrays.stream(winningValue.split(","))
            .map(String::trim)
            .mapToInt(Integer::parseInt)
            .boxed()
            .collect(Collectors.toList());
    }
}
