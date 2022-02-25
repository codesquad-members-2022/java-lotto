package lotto.domain;

import java.util.List;

public abstract class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = createLotto(numbers);
    }

    public abstract List<Integer> createLotto(List<Integer> numbers);

    public String showLottoNumbers() {
        return numbers.toString();
    }

    public int getCorrectNumberCount(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .mapToInt(this::correctNumber)
                .sum();
    }

    private int correctNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
