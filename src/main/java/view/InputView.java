package view;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    public static final String REQUEST_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String REQUEST_LOTTO_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_LOTTO_BONUS_NUMBER = "보너스 볼을 입력해주세요";
    private static final Scanner scanner = new Scanner(System.in);
    public static final String REQUEST_CUSTOM_TICKET_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";

    private InputView() {
    }

    public static int requestMoney() {
        System.out.println(REQUEST_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String[] requestLottoWinningNumbers() {
        System.out.println(REQUEST_LOTTO_NUMBERS_MESSAGE);
        String numbers = scanner.nextLine();
        return numbers.split(",");
    }

    public static String requestBonusNumber() {
        System.out.println(REQUEST_LOTTO_BONUS_NUMBER);
        return scanner.nextLine();
    }

    public static int requestCustomTicketCount() {
        System.out.println(REQUEST_CUSTOM_TICKET_COUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int[] requestCustomTicketNumber() {
        return Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
    }

    public static void requestCustomTicketNumberMessage() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void close() {
        scanner.close();
    }
}
