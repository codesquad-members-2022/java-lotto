package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    public LottoTicket(int[] numbers) {
        validateLength(numbers);

        validateNoDuplicate(numbers);
        this.lottoNumbers = parseNumbers(numbers);
    }

    public int matchNumbers(LottoTicket anotherTicket) {
        return lottoNumbers.stream()
                .map(anotherTicket::contains)
                .mapToInt(b -> b ? 1 : 0)
                .sum();
    }
    
    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    private void validateLength(int[] numbers) {
        if (numbers.length != NUMBER_COUNT) {
            throw new IllegalArgumentException(String.format("%d개의 숫자가 필요합니다.", NUMBER_COUNT));
        }
    }

    private void validateNoDuplicate(int[] numbers) {
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException("로또 번호는 각각 달라야 합니다.");
        }
    }

    private boolean hasDuplicate(int[] numbers) {
        int lengthWithoutDuplicate = (int) Arrays.stream(numbers)
                .distinct()
                .count();
        return numbers.length != lengthWithoutDuplicate;
    }

    private List<LottoNumber> generateRandomLottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(NUMBER_COUNT)
                .sorted()
                .map(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }

    private List<LottoNumber> parseNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .mapToObj(LottoNumber::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
