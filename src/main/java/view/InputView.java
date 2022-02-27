package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String REQUEST_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해주세요";
    private static final String REQUEST_CUSTOM_TICKET_COUNT_ERROR_MESSAGE = "0 이상의 정수를 입력해주세요.";
    private static final String REQUEST_CUSTOM_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_MINIMUM_PRICE_MESSAGE = "Lotto의 최소 가격은 1000원부터 입니다.";
    private static final String DELIMITER = ",";

    private InputView() {
    }

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        int userMoney = Integer.parseInt(scanner.nextLine());
        if (userMoney < 1000) {
            throw new IllegalArgumentException(REQUEST_MINIMUM_PRICE_MESSAGE);
        }
        return userMoney;
    }

    public static String[] requestLottoWinningNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBERS_MESSAGE);
        String numbers = scanner.nextLine();
        return numbers.split(DELIMITER);
    }

    public static String requestBonusNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_NUMBER);
        return scanner.nextLine();
    }

    public static int requestCustomTicketCount() {
        System.out.println(REQUEST_CUSTOM_TICKET_COUNT_MESSAGE);
        int count = Integer.parseInt(scanner.nextLine());
        if (count < 0) {
            throw new IllegalArgumentException(REQUEST_CUSTOM_TICKET_COUNT_ERROR_MESSAGE);
        }
        return count;
    }

    public static int[] requestCustomTicketNumber() {
        return Arrays.stream(scanner.nextLine().split(DELIMITER)).mapToInt(Integer::parseInt).toArray();
    }

    public static void requestCustomTicketNumberMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void close() {
        scanner.close();
    }
}
