package domain.lotto;

import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumber {

    private static final Map<Integer, LottoNumber> LOTTO_NUMBER_POOL;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;

    static {
        LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), LottoNumber::new));
    }

    private final int number;

    private LottoNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public static LottoNumber of(int number) {
        return LOTTO_NUMBER_POOL.get(number);
    }

    public static LottoNumber getLottoRandomLottoNumber() {
        int randomNumber = (int) (Math.random() * MAX_RANDOM_NUMBER) + MIN_RANDOM_NUMBER;
        return of(randomNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
