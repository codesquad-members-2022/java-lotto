package app.lotto.validation;

import app.lotto.domain.LottoTicket;

import java.util.HashSet;
import java.util.Set;

public class InputViewValidator {

    public static void validateAmountUnit(int amount, int unit) {
        if (amount % unit != 0) {
            throw new IllegalArgumentException(String.format("%d 단위로 입력해주세요.", unit));
        }
    }

    public static void validateNumbersCount(String[] numbers, int count) {
        for (String num : numbers) {
            parseIntTrim(num);
        }

        if (numbers.length != count) {
            throw new IllegalArgumentException(String.format("당첨번호는 %d개 입력해 주세요.", count));
        }
    }

    public static void validateNumbersRange(LottoTicket winningNumbers, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("최대값보다 최소값이 크면 안 됩니다.");
        }

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
            numberSet.add(parseIntTrim(num));
        }

        if (numbers.length != numberSet.size()) {
            throw new IllegalArgumentException("중복되지 않은 번호를 입력해주세요.");
        }
    }

    private static int parseIntTrim(String num) {
        return Integer.parseInt(num.trim());
    }
}
