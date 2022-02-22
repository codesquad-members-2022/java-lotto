package domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumbersValidator {

    public static void validate(List<Integer> lottoNumbers) {
        checkAmount(lottoNumbers.size());
        checkDuplicatedNumber(lottoNumbers);
        for (int number : lottoNumbers) {
            checkNumberRange(number);
        }
    }

    private static void checkAmount(int amount) {
        if (amount != LottoGenerator.LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("적절한 당첨 번호 개수가 아닙니다!!");
        }
    }

    private static void checkDuplicatedNumber(List<Integer> list) {
        HashSet<Integer> hashSet = new HashSet<>(list);
        if (hashSet.size() != list.size()) {
            throw new IllegalArgumentException("중복된 당첨번호는 입력할 수 없습니다!!");
        }
    }

    private static void checkNumberRange(int number) {
        if ((LottoGenerator.LOTTO_NUMBER_MIN > number) || (number
            > LottoGenerator.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("적절한 당첨 번호가 아닙니다!!");
        }
    }
}
