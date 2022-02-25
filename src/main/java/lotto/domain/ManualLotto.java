package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class ManualLotto extends Lotto {

    public ManualLotto(List<Integer> numbers) {
        super(numbers);
    }

    @Override
    public List<Integer> createLotto(List<Integer> numbers) {
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
