package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoSheetValidator {

    public void validate(List<Integer> lottoNumbers, int standardLottoSize) throws IllegalArgumentException {
        checkSize(lottoNumbers.size(), standardLottoSize);
        checkDuplicatedNumber(lottoNumbers);
        for (int number : lottoNumbers) {
            checkNumberRange(number);
        }
    }

    private void checkSize(int lottoNumberSize, int standardLottoSize) throws IllegalArgumentException {
        if (lottoNumberSize != standardLottoSize) {
            throw new IllegalArgumentException("적절한 당첨 번호 개수가 아닙니다!!");
        }
    }

    private void checkDuplicatedNumber(List<Integer> list) throws IllegalArgumentException {
        Set<Integer> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            throw new IllegalArgumentException("중복된 당첨번호는 입력할 수 없습니다!!");
        }
    }

    private void checkNumberRange(int number) throws IllegalArgumentException {
        if ((LottoGenerator.LOTTO_NUMBER_MIN > number) || (number > LottoGenerator.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("적절한 당첨 번호가 아닙니다!!");
        }
    }
}
