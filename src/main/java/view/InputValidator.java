package view;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Lotto;

class InputValidator {

    private static final InputValidator validator = new InputValidator();

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        return validator;
    }

    int validateInteger(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw subDivideNumberFormatException(input);
        }
    }

    private IllegalArgumentException subDivideNumberFormatException(String input) {
        if (input == null || !input.matches("\\d+")) {
            return new IllegalArgumentException("숫자를 입력해주세요.");
        }
        return new IllegalArgumentException("int 범위 내로 입력해주세요.");
    }

    int validatePositiveInteger(String input) throws IllegalArgumentException {
        int number = validateInteger(input);
        if (number < 1) {
            throw new IllegalArgumentException("양수를 입력해 주세요.");
        }
        return number;
    }

    List<Integer> validateWinningNumber(String input) throws IllegalArgumentException {
        String[] split = input.split(",");
        Set<Integer> numberSet = Arrays.stream(split)
            .map(String::trim)
            .map(this::validateInteger)
            .map(this::validateLottoNumber)
            .collect(Collectors.toSet());
        if (numberSet.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(
                "중복 없는 " + Lotto.LOTTO_NUMBER_COUNT + "개의 번호를 입력해주세요.");
        }
        return List.copyOf(numberSet);
    }

    int validateLottoNumber(int input) throws IllegalArgumentException {
        if (input < Lotto.MIN_LOTTO_NUMBER || input > Lotto.MAX_LOTTO_NUMBER) {
            throw new IllegalArgumentException(Lotto.MIN_LOTTO_NUMBER
                + "~"
                + Lotto.MAX_LOTTO_NUMBER
                + " 내의 숫자를 입력해주세요.");
        }
        return input;
    }

    int validateBonusNumber(List<Integer> winningNumbers, String input) throws
        IllegalArgumentException {
        int number = validator.validateInteger(input);
        int bonusNumber = validator.validateLottoNumber(number);
        boolean isDuplicate = winningNumbers.stream()
            .anyMatch(n -> n == bonusNumber);
        if (isDuplicate) {
            throw new IllegalArgumentException("중복되지 않는 값을 입력해주세요.");
        }
        return bonusNumber;
    }
}
