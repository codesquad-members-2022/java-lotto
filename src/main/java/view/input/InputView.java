package view.input;

import domain.Money;

import java.util.Scanner;

public class InputView {

    private static final String REQUEST_INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.\nMoney > ";
    private static final Scanner scanner = new Scanner(System.in);

    public static void close() {
        scanner.close();
    }

    public static Money inputMoney() {
        System.out.print(REQUEST_INPUT_MONEY_MESSAGE);
        int inputMoney = Integer.parseInt(scanner.nextLine());
        return new Money(inputMoney);
    }
}
