package domain;

import java.util.List;

public class WinningNumbers {

    private static final int BONUS_NUMBER_INDEX = 6;

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbersWithoutBonus() {
        return winningNumbers.subList(0, BONUS_NUMBER_INDEX);
    }

    public int getBonusNumber() {
        return winningNumbers.get(BONUS_NUMBER_INDEX);
    }
}
