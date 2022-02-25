package app.lotto.validation;

import app.lotto.domain.LottoTicket;

import java.util.HashSet;
import java.util.Set;

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

    public static void validateNumbersRange(LottoTicket winningNumbers, int min, int max) {
        for (int i = 0; i < winningNumbers.getSize(); i++) {
            validateRange(min, max, winningNumbers.getNumber(i));
        }
    }

    public static void validateRange(int min, int max, int num) {
        if (num < min || num > max) {
            throw new IllegalArgumentException(String.format("%d 부터 %d 까지의 숫자만 입력해주세요.", min, max));
        }
    }

    public static void validateDuplicatedNumber(String[] numbers) {
        Set<Integer> numberSet = new HashSet<>();

        for (String num : numbers) {
            numberSet.add(Integer.parseInt(num.trim()));
        }

        if (numbers.length != numberSet.size()) {
            throw new IllegalArgumentException("중복되지 않은 번호를 입력해주세요.");
        }
    }
}
