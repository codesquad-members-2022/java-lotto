package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto extends Lotto {

    private final int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        this.bonusNumber = bonusNumber;
    }

    @Override
    public List<Integer> createLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
