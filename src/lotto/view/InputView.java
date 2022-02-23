package lotto.view;

import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPaidAmount() {
        System.out.println("구입 금액을 입력해주십시오.");
        return Integer.parseInt(scanner.nextLine());
    }

    public int[] getWinningNumber() {
        System.out.println("당첨 번호를 입력해주십시오.");
        String winningNumber = scanner.nextLine();
        return Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public void close() {
        scanner.close();
    }
}
