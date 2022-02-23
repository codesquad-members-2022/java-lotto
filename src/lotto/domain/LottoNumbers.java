package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> lottoNumberPool;

    public LottoNumbers() {
        initialize();
    }

    public List<LottoNumber> generateRandomLottoNumbers() {
        return Collections.unmodifiableList(lottoNumberPool.subList(0, LOTTO_NUMBER_COUNT));
    }

    public LottoNumber generateRandomBonusNumber() {
        return lottoNumberPool.get(LOTTO_NUMBER_COUNT);
    }

    public static List<LottoNumber> parseNumbers(int[] numbers) {
        validateLength(numbers);
        validateNoDuplicate(numbers);

        return Arrays.stream(numbers)
                .sorted()
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private void initialize() {
        List<Integer> list = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(list);

        lottoNumberPool = list.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
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
