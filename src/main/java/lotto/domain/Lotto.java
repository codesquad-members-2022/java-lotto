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

    /**
     * 현재 숫자가 리스트에 있는지 판단하는 메소드
     * number가 현재 numbers에 있으면 1 리턴
     *                       없으면 0 리턴
     * @param number
     * @return
     */
    private int correctNumber(int number) {
        if (numbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
