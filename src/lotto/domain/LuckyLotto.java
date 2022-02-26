package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LuckyLotto {

    private final List<Integer> luckyNumbers;
    private final int bonusNumber;

    public LuckyLotto(int[] luckyNumbers, int bonusNumber) {
        if (luckyNumbers.length != 6) {
            throw new IllegalArgumentException();
        }
        this.luckyNumbers = Arrays.stream(luckyNumbers)
            .boxed()
            .collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getNumbers() {
        return List.copyOf(luckyNumbers);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
