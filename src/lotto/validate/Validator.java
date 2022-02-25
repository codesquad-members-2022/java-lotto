package lotto.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;

public class Validator {

    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH = "로또 번호는 6개를 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE = "로또번호는 1~45 범위의 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION = "로또번호는 서로 다른 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_BONUS_DUPLICATION = "보너스 번호는 로또번호와 다른 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_INVALID_LOTTO_PRICE = Lotto.PRICE + "원의 배수로 입력해주세요";
    private static final String ERROR_MESSAGE_FOR_INVALID_NUM_OF_LOTTO = "투입한 돈보다 더 많은 로또번호를 입력할 수 없습니다.";
    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public static void isValidLottoNumbers(List<Integer> lottoNumbers) {
        validateLength(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

    public static void isValidLuckyNumber(List<Integer> lottoNumbers, int bonusNumber) {
        isValidLottoNumbers(lottoNumbers);
        validateRange(bonusNumber);
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_BONUS_DUPLICATION);
        }
    }

    private static void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        if (lottoSet.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION);
        }
    }

    private static void validateRange(List<Integer> lottoNumbers) {
        boolean isNotValidRangeLottoNumber = lottoNumbers.stream()
            .anyMatch(number -> (number < MIN_VALUE || number > MAX_VALUE));
        if (isNotValidRangeLottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE);
        }
    }

    private static void validateRange(int number) {
        if (number < MIN_VALUE || number > MAX_VALUE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE);
        }
    }

    private static void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH);
        }
    }

    public static void validateMoney(int money) {
        if (money % Lotto.PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_LOTTO_PRICE);
        }
    }

    public static void validateNumOfLotto(int numOfLotto, int inputMoney) {
        if (numOfLotto > inputMoney / Lotto.PRICE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_INVALID_NUM_OF_LOTTO);
        }
    }
}
