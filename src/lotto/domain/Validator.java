package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    private static final int LOTTO_NUMBERS_LENGTH = 6;
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH = "로또 번호는 6개를 입력해주세요.";
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE = "로또번호는 1~45 범위의 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION = "로또번호는 서로 다른 숫자로 입력해주세요.";

    private static List<Integer> isValidLottoNumbers(List<Integer> lottoNumbers) {
        validateLength(lottoNumbers);
        validateRange(lottoNumbers);
        validateDuplication(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateDuplication(List<Integer> lottoNumbers) {
        Set<Integer> abcd = new HashSet<>(lottoNumbers);
        if (abcd.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION);
        }
    }

    private static void validateRange(List<Integer> lottoNumbers) {
        boolean isNotValidRangeLottoNumber = lottoNumbers.stream()
            .anyMatch((number) -> (number < MIN_VALUE || number > MAX_VALUE));
        if (isNotValidRangeLottoNumber) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE);
        }
    }

    private static void validateLength(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH);
        }
    }
}
