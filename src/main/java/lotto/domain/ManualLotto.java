package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto extends Lotto {
    private static final int PICK_NUMBER_LENGTH = 6;

    public ManualLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public List<Integer> createLotto(List<Integer> numbers) {
        return numbers.stream()
                .limit(PICK_NUMBER_LENGTH)
                .sorted()
                .collect(Collectors.toList());
    }
}
