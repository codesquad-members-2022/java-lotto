package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private static final int PICK_NUMBER_LENGTH = 6;
    private final List<Integer> lottos;


    public Lotto(List<Integer> numbers) {
        this.lottos = pickSixNumbers(numbers);
    }

    private List<Integer> pickSixNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(PICK_NUMBER_LENGTH)
                .collect(Collectors.toList());
    }
}
