package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int PICK_NUMBER_LENGTH = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = pickSixNumbers(numbers);
    }

    private List<Integer> pickSixNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(PICK_NUMBER_LENGTH)
                .sorted()
                .collect(Collectors.toList());
    }

    public String showLottoNumbers() {
        return numbers.toString();
    }

    public int getCorrectNumberCount(List<Integer> winningNumbers) {
        int correctCount = 0;

        for (int number : winningNumbers) {
            correctCount += correctNumber(number);
        }

        return correctCount;
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
