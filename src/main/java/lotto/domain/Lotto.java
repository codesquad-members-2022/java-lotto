package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = pickSixNumbers(numbers);
    }

    private List<Integer> pickSixNumbers(List<Integer> numbers) {
        int pickNumberLength = 6;

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(pickNumberLength)
                .sorted()
                .collect(Collectors.toList());
    }

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
