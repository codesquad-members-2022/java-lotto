package domain.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomLotto extends Lotto {

    private static final List<Integer> allNumbers;

    static {
        allNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());
    }

    private RandomLotto(List<Integer> lottoNumbers) {
        super(lottoNumbers);
    }

    public static RandomLotto generate() {
        Collections.shuffle(allNumbers);
        List<Integer> randomNumbers = List.copyOf(allNumbers.subList(0, 6));
        return new RandomLotto(randomNumbers);
    }
}
