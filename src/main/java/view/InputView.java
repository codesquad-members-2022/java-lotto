package view;

import java.util.Scanner;

public class InputView {
    public static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        int userMoney = scanner.nextInt();
        scanner.nextLine();
        return userMoney;
    }

    public static String[] requestLottoNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBERS_MESSAGE);
        String numbers = scanner.nextLine();
        return numbers.split(",");
    }
}
