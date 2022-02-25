package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    private static final List<Integer> lottoNumberPool = new ArrayList<>();

    static {
        initialize();
    }

    public static LottoTicket issueLottoTicketWithRandomNumbers() {
        return new LottoTicket(getLottoNumbers());
    }

    public static LottoTicket issueLottoTicketWithSelectNumbers(int[] numbers) {
        return new LottoTicket(new LottoNumbers(numbers));
    }

    public static WinningNumber selectWinningNumber(int[] numbers, int bonusNumber) {
        return new WinningNumber(new LottoNumbers(numbers), new LottoNumber(bonusNumber));
    }

    private static void initialize() {
        IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .forEach(lottoNumberPool::add);
    }

    private static void shuffleNumberPool() {
        Collections.shuffle(lottoNumberPool);
    }

    private static LottoNumbers getLottoNumbers() {
        shuffleNumberPool();

        return new LottoNumbers(lottoNumberPool.stream()
                .limit(LottoNumbers.LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList()));
    }
}
