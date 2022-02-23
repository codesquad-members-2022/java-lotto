package lotto_game.domain;

import java.util.List;

public class WinningNumbers {
    private List<Integer> numbers;
    int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbersList() {
        return numbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
