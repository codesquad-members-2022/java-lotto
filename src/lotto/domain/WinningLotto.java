package lotto.domain;

import static lotto.validate.Validator.isContainBonusNumber;
import static lotto.validate.Validator.isValidLottoNumbers;

import java.util.Collections;
import java.util.List;

public class WinningLotto {

    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<LottoNumber> winningNumbers, int bonusNumber)
        throws IllegalArgumentException {
        isValidLottoNumbers(winningNumbers);
        isContainBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public List<LottoNumber> getNumbers() {
        return Collections.unmodifiableList(winningNumbers);
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}
