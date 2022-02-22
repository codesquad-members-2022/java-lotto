package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    public static final int PRICE = 1000;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;
    private static final int NUMBER_COUNT = 6;
    private final List<Integer> lottoNumbers;

    public LottoTicket() {
        this.lottoNumbers = generateRandomLottoNumbers();
    }

    public LottoTicket(int[] numbers) {
        validateLength(numbers);
        validateRange(numbers);
        validateNoDuplicate(numbers);
        this.lottoNumbers = parseNumbers(numbers);
    }

    private void validateRange(int[] numbers) {
        validateMinimum(numbers);
        validateMaximum(numbers);
    }

    private void validateMaximum(int[] numbers) {
        if (isAboveMaximum(numbers)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d보다 작아야 합니다.", MAXIMUM_NUMBER));
        }
    }

    private boolean isAboveMaximum(int[] numbers) {
        return Arrays.stream(numbers).max().orElseThrow() > MAXIMUM_NUMBER;
    }

    private void validateMinimum(int[] numbers) {
        if (isBelowMinimum(numbers)) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d보다 커야 합니다.", MINIMUM_NUMBER));
        }
    }

    private boolean isBelowMinimum(int[] numbers) {
        return Arrays.stream(numbers).min().orElseThrow() < MINIMUM_NUMBER;
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

    private List<Integer> generateRandomLottoNumbers() {
        List<Integer> numbers = IntStream.rangeClosed(MINIMUM_NUMBER, MAXIMUM_NUMBER)
                .boxed()
                .collect(Collectors.toList());

        Collections.shuffle(numbers);

        return numbers.stream()
                .limit(NUMBER_COUNT)
                .sorted()
                .collect(Collectors.toUnmodifiableList());
    }

    private List<Integer> parseNumbers(int[] numbers) {
        return Arrays.stream(numbers)
                .sorted()
                .boxed()
                .collect(Collectors.toUnmodifiableList());
    }
}
