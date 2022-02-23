package lotto.domain;

import java.util.List;

public class LuckyLotto {

    private final List<Integer> luckyNumbers;
    private final int bonusNumber;

    public LuckyLotto(List<Integer> luckyNumbers, int bonusNumber) {
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
