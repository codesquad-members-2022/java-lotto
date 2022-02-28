package view;

import exception.LottoIllegalInputException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import domain.Lotto.Lotto;

public class InputValidator {

    private static final InputValidator validator = new InputValidator();

    private InputValidator() {
    }

    public static InputValidator getInstance() {
        return validator;
    }

    public int validateInteger(String input) throws LottoIllegalInputException {
        int integer = 0;
        try {
            integer = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            subDivideNumberFormatException(input);
        }
        return integer;
    }

    private void subDivideNumberFormatException(String input) throws LottoIllegalInputException {
        if (input == null || !input.matches("\\d+")) {
            throw new LottoIllegalInputException("숫자를 입력해주세요.");
        }
        throw new LottoIllegalInputException("int 범위 내로 입력해주세요.");
    }

    public int validatePositiveInteger(String input) throws LottoIllegalInputException {
        int number = validateInteger(input);
        if (number < 1) {
            throw new LottoIllegalInputException("양수를 입력해 주세요.");
        }
        return number;
    }

    public int validateManualLottoCount(int userMoney, String input) throws LottoIllegalInputException {
        int count = validatePositiveInteger(input);
        int purchasableCount = userMoney / Lotto.PRICE;
        if (count > purchasableCount) {
            throw new LottoIllegalInputException("구매한 로또 개수 내에서 입력해 주세요.");
        }
        return count;
    }

    public List<Integer> validateLottoNumbers(String input) throws LottoIllegalInputException {
        String[] split = input.split(",");
        Set<Integer> numberSet = Arrays.stream(split)
            .map(String::trim)
            .map(this::validateInteger)
            .map(this::validateLottoNumber)
            .collect(Collectors.toSet());
        if (numberSet.size() != Lotto.LOTTO_NUMBER_COUNT) {
            throw new LottoIllegalInputException(
                "중복 없는 " + Lotto.LOTTO_NUMBER_COUNT + "개의 번호를 입력해주세요.");
        }
        return List.copyOf(numberSet);
    }

    public int validateLottoNumber(int input) throws LottoIllegalInputException {
        if (input < Lotto.MIN_LOTTO_NUMBER || input > Lotto.MAX_LOTTO_NUMBER) {
            throw new LottoIllegalInputException(Lotto.MIN_LOTTO_NUMBER
                + "~"
                + Lotto.MAX_LOTTO_NUMBER
                + " 내의 숫자를 입력해주세요.");
        }
        return input;
    }

    public int validateBonusNumber(List<Integer> winningNumbers, String input) throws
        LottoIllegalInputException {
        int number = validator.validateInteger(input);
        int bonusNumber = validator.validateLottoNumber(number);
        boolean isDuplicate = winningNumbers.stream()
            .anyMatch(n -> n == bonusNumber);
        if (isDuplicate) {
            throw new LottoIllegalInputException("중복되지 않는 값을 입력해주세요.");
        }
        return bonusNumber;
    }
}
