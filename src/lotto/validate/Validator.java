package lotto.validate;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

public class Validator {

    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBERS_LENGTH = "로또 번호는 6개를 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION = "로또번호는 서로 다른 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_LOTTO_BONUS_DUPLICATION = "보너스 번호는 로또번호와 다른 숫자로 입력해주세요.";
    private static final String ERROR_MESSAGE_FOR_INVALID_LOTTO_PRICE = Lotto.PRICE + "원의 배수로 입력해주세요";
    private static final String ERROR_MESSAGE_FOR_INVALID_NUM_OF_LOTTO = "투입한 돈보다 더 많은 로또번호를 입력할 수 없습니다.";
    private static final String ERROR_MESSAGE_FOR_CANNOT_CONVERT_TO_INTEGER = "숫자로 입력해주세요.";

	public static void isValidLottoNumbers(List<LottoNumber> lottoNumbers) {
        validateLength(lottoNumbers);
        validateDuplication(lottoNumbers);
    }

	public static void isValidWinningNumber(List<LottoNumber> lottoNumbers, int bonusNumber) {
        isValidLottoNumbers(lottoNumbers);
        if (lottoNumbers.contains(new LottoNumber(bonusNumber))) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_BONUS_DUPLICATION);
        }
    }

	private static void validateDuplication(List<LottoNumber> lottoNumbers) {
		Set<LottoNumber> lottoSet = new HashSet<>(lottoNumbers);
        if (lottoSet.size() != Lotto.NUM_OF_LOTTO_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_DUPLICATION);
        }
    }

	private static void validateLength(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.NUM_OF_LOTTO_NUMBER) {
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

    public static int validateStringToInteger(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_FOR_CANNOT_CONVERT_TO_INTEGER);
        }
    }

}
