package lotto.view;

import lotto.domain.LottoTicket;

import java.util.Scanner;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InputView {
    private final Scanner scanner = new Scanner(System.in);

    public int getPaidAmount() {
        System.out.printf("구입 금액을 입력해주십시오. 로또는 한 장에 %,d원입니다.%n", LottoTicket.PRICE);
        return getUnsignedInt();
    }

    public int[] getWinningNumber() {
        System.out.println("당첨 번호를 입력해주십시오.");
        return getUnsignedIntArray();
    }

    public int getBonusNumber() {
        System.out.println("보너스 볼을 입력해주십시오.");
        return getUnsignedInt();
    }

    public int getManualTicketCount(int maxCount) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int input = getUnsignedInt();

        if (input > maxCount) {
            throw new IllegalArgumentException(String.format("최대 %d까지만 입력할 수 있습니다.", maxCount));
        }

        return input;
    }

    public int[][] getManualLottoNumbers(int manualTicketCount) {
        System.out.printf("조상님이 가르쳐준 번호를 입력해 주세요. (%d장)%n", manualTicketCount);
        return IntStream.range(0, manualTicketCount)
                .mapToObj(i -> getUnsignedIntArray())
                .toArray(int[][]::new);
    }

    public void close() {
        scanner.close();
    }

    private int getUnsignedInt() {
        String input = scanner.nextLine();
        return parseUnsignedInt(input);
    }

    private int[] getUnsignedIntArray() {
        String input = scanner.nextLine();
        validateUnsignedIntArrayString(input);
        return Stream.of(input.split(","))
                .mapToInt(this::parseUnsignedInt)
                .toArray();
    }

    private int parseUnsignedInt(String input) {
        validateUnsignedIntString(input);

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("잘못된 수가 입력되었습니다. 32비트 int로 표현 가능한 값을 입력해야 합니다");
        }
    }

    private void validateUnsignedIntString(String input) {
        if (input.matches("\\d+")) {
            return;
        }

        throw new IllegalArgumentException("부호 없는 정수를 입력해야 합니다.");
    }

    private void validateUnsignedIntArrayString(String input) {
        if (input.matches("\\d+(\\s*,\\s*\\d+)*")) {
            return;
        }

        throw new IllegalArgumentException("쉼표(,)로 분리된 부호 없는 정수들을 입력해야 합니다");
    }
}
