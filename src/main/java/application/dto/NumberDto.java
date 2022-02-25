package application.dto;

import java.util.List;

public class NumberDto {

    private final int userId;
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public NumberDto(int userId, List<Integer> winningNumber, int bonusNumber) {
        this.userId = userId;
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public int getUserId() {
        return userId;
    }
}
