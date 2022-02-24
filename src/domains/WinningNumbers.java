package domains;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;
    private int bonusBall;

    public WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
        this.bonusBall = bonusBall;
    }

    public List<Integer> getNumbers() {
        return this.winningNumbers;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
