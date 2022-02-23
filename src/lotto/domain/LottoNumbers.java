package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private List<Integer> lottoNumberPool;

    public LottoNumbers() {
        initialize();
    }

    public List<LottoNumber> generateRandomLottoNumbers() {
        return lottoNumberPool.stream()
                .limit(LOTTO_NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public LottoNumber generateRandomBonusNumber() {
        return new LottoNumber(lottoNumberPool.get(LOTTO_NUMBER_COUNT));
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
        lottoNumberPool = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(lottoNumberPool);
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
