package nb993.model;

import java.util.ArrayList;
import java.util.List;
import nb993.util.LottoUtil;

public class WinningNumber {

    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumbers, int bonusNumber) {
        LottoUtil.validate(winningNumbers, bonusNumber);
        this.winningNumbers = new ArrayList<>(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getNumber(int idx) {
        return winningNumbers.get(idx);
    }
}
