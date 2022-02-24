package domains;

import java.util.List;

public class WinningNumbers implements BasicWinningNumbers{
    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers, int bonusBall) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getNumbers() {
        return this.winningNumbers;
    }
}
