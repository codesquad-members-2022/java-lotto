package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumberPool {
    private static final List<Integer> LOTTO_NUMBER_POOL = new ArrayList<>();

    static {
        initialize();
    }

    private static void initialize() {
        IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .forEach(LOTTO_NUMBER_POOL::add);
    }

    public static void shuffle() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
    }

    public static LottoNumbers getLottoNumbers() {
        shuffle();

        return new LottoNumbers(LOTTO_NUMBER_POOL.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList()));
    }
}
