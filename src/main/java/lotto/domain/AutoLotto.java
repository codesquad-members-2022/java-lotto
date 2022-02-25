package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AutoLotto extends Lotto {
    private static final int PICK_NUMBER_LENGTH = 6;

    public AutoLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public List<Integer> createLotto(List<Integer> numbers) {
        return pickSixNumbers(numbers);
    }

    private List<Integer> pickSixNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(PICK_NUMBER_LENGTH)
                .sorted()
                .collect(Collectors.toList());
    }
}
