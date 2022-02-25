package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoFactory {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> lottoNumberPool = new ArrayList<>();

    static {
        initialize();
    }

    public static LottoTicket issueLottoTicketWithRandomNumbers() {
        shuffleNumberPool();
        return new LottoTicket(getLottoNumbers());
    }

    public static LottoTicket issueLottoTicketWithSelectNumbers(int[] numbers) {
        return new LottoTicket(parseNumbers(numbers));
    }

    public static WinningNumber drawWinningNumber() {
        shuffleNumberPool();
        return new WinningNumber(getLottoNumbers(), getBonusNumber());
    }

    public static WinningNumber selectWinningNumber(int[] numbers, int bonusNumber) {
        return new WinningNumber(parseNumbers(numbers), new LottoNumber(bonusNumber));
    }

    private static void initialize() {
        IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .forEach(lottoNumberPool::add);

        Collections.shuffle(lottoNumberPool);
    }

    private static void shuffleNumberPool() {
        Collections.shuffle(lottoNumberPool);
    }

    private static List<LottoNumber> getLottoNumbers() {
        return lottoNumberPool.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static LottoNumber getBonusNumber() {
        return new LottoNumber(lottoNumberPool.get(LOTTO_NUMBER_COUNT));
    }

    private static List<LottoNumber> parseNumbers(int[] numbers) {
        validateLength(numbers);
        validateNoDuplicate(numbers);

        return Arrays.stream(numbers)
                .sorted()
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private static void validateLength(int[] numbers) {
        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("%d개의 숫자가 필요합니다.", LOTTO_NUMBER_COUNT));
        }
    }

    private static void validateNoDuplicate(int[] numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 각각 달라야 합니다.");
        }
    }

    private static boolean hasDuplicate(int[] numbers) {
        int lengthWithoutDuplicate = (int) Arrays.stream(numbers)
                .distinct()
                .count();
        return numbers.length != lengthWithoutDuplicate;
    }
}
