package app.lotto.validation;

import java.util.List;

public class InputViewValidator {

    public static void validateAmountUnit(int amount, int unit) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException("1000원 단위로 입력해주세요.");
        }
    }

    public static void validateNumbersCount(String[] numbers, int count) {
        for (String num : numbers) {
            Integer.parseInt(num.trim());
        }

        if (numbers.length != count) {
            throw new IllegalArgumentException(String.format("당첨번호는 %d개 입력해 주세요.", count));
        }
    }

    public static void validateNumbersRange(List<Integer> winningNumbers, int min, int max) {
        for (int num : winningNumbers) {
            validateRange(min, max, num);
        }
    }

    public static void validateRange(int min, int max, int num) {
        if (num < min || num > max) {
            throw new IllegalArgumentException("1부터 45까지의 숫자만 입력해주세요.");
        }
    }
}
