package lotto.domain;

import static lotto.validate.Validator.isValidWinningNumber;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningNumbers;
    private final int bonusNumber;

    public WinningLotto(List<LottoNumber> luckyNumbers, int bonusNumber)
        throws IllegalArgumentException {
        isValidWinningNumber(luckyNumbers, bonusNumber);
        this.winningNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
