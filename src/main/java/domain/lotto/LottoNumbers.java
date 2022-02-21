package domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private static final List<LottoNumber> LOTTO_NUMBER_POOL;
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 45;
    private static final int LOTTONUMBER_SIZE = 6;

    static {
        LOTTO_NUMBER_POOL = IntStream.rangeClosed(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER)
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toList());
    }

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        lottoNumbers = createRandomLottoNumbers();
    }

    private List<LottoNumber> createRandomLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_POOL);
        return LOTTO_NUMBER_POOL.stream()
                .limit(LOTTONUMBER_SIZE)
                .collect(Collectors.toList());
    }

    public int getLottoNumbersSize() {
        return lottoNumbers.size();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (LottoNumber lottoNumber : lottoNumbers) {
            sb.append(lottoNumber.getNumber()).append(" ");
        }

        return sb.toString();
    }
}
