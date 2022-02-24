package application.dto;

import java.util.List;

public class NumberDto {

    private List<Integer> winningNumber;
    private int bonusNumber;

    public NumberDto(List<Integer> winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
