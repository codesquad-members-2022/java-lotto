package lotto.domain;

import static lotto.domain.Validator.isValidLuckyNumber;

import java.util.List;

public class LuckyLotto {

    private final List<Integer> luckyNumbers;
    private final int bonusNumber;

    public LuckyLotto(List<Integer> luckyNumbers, int bonusNumber) throws IllegalArgumentException {
        isValidLuckyNumber(luckyNumbers, bonusNumber);
        this.luckyNumbers = luckyNumbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(luckyNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
