package lotto.view;

import lotto.domain.LottoTicket;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPaidAmount() {
        System.out.printf("구입 금액을 입력해주십시오. 로또는 한 장에 %,d원입니다.%n", LottoTicket.PRICE);
        return getInt();
    }

    public int[] getWinningNumber() {
        System.out.println("당첨 번호를 입력해주십시오.");
        return getIntArray();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해주십시오.");
        return getInt();
    }

    public void close() {
        scanner.close();
    }

    public int getManualTicketCount(int maxCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int input = getInt();

        if (input > maxCount) {
            throw new IllegalArgumentException(String.format("최대 %d까지만 입력할 수 있습니다.", maxCount));
        }

        return input;
    }

    public int[][] getManualLottoNumbers(int manualTicketCount) {
        System.out.printf("조상님이 가르쳐준 번호를 입력해 주세요. (%d장)%n", manualTicketCount);
        return IntStream.range(0, manualTicketCount)
                .mapToObj(i -> getIntArray())
                .toArray(int[][]::new);
    }

    private int getInt() {
        return Integer.parseInt(scanner.nextLine());
    }

    private int[] getIntArray() {
        String winningNumber = scanner.nextLine();
        return Stream.of(winningNumber.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
