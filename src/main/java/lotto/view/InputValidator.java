package lotto.view;

import java.util.List;

public class InputValidator {
    private static final String NOT_NUMBER_REGEX = "[0-9]+";
    private static final int LESS_PURCHASE_AMOUNT = 1000;

    public static boolean validateInputAllNumber(String input) {
        if (!input.matches(NOT_NUMBER_REGEX) || Integer.parseInt(input) < LESS_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("숫자만 입력가능하며 1000원 이상으로 입력해주세요.");
        }

        return true;
    }

    public static boolean validateInputManualLottoCount(String input) {
        if (!input.matches(NOT_NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }

        return true;
    }

    public static boolean validateIsNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력가능합니다.");
        }

        return true;
    }

    public static boolean validateDuplicateWinningNumber(List<Integer> winningNumbers, String bonusNumber) {
        if (winningNumbers.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("보너스 번호는 당첨번호와 중복될 수 없습니다.");
        }

        return true;
    }
}
