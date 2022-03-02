package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final String INPUT_FIELD_NAME = "lottoNumbers_";
    private final List<LottoNumber> lottoNumberList;

    public LottoNumbers(List<LottoNumber> lottoNumberList) {
        validateLength(lottoNumberList);
        validateNoDuplicate(lottoNumberList);
        this.lottoNumberList = lottoNumberList;
    }

    public LottoNumbers(int[] numbers) {
        validateLength(numbers);
        validateNoDuplicate(numbers);
        this.lottoNumberList = parseNumbers(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumberList.contains(lottoNumber);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumberList.stream();
    }

    @Override
    public String toString() {
        return lottoNumberList.toString();
    }

    private List<LottoNumber> parseNumbers(int[] numbers) {
        try {
            return Arrays.stream(numbers)
                    .sorted()
                    .mapToObj(LottoNumber::new)
                    .collect(Collectors.toUnmodifiableList());
        } catch (InvalidLottoNumberException e) {
            throw new InvalidLottoNumberException(e, numbers);
        }
    }

    private void validateLength(List<LottoNumber> lottoNumberList) {
        validateLength(lottoNumberListToArray(lottoNumberList));
    }

    private void validateNoDuplicate(List<LottoNumber> lottoNumberList) {
        validateNoDuplicate(lottoNumberListToArray(lottoNumberList));
    }

    private int[] lottoNumberListToArray(List<LottoNumber> lottoNumberList) {
        return lottoNumberList.stream()
                .mapToInt(LottoNumber::getNumber)
                .toArray();
    }

    private void validateLength(int[] numbers) {
        if (numbers.length != LOTTO_NUMBER_COUNT) {
            throw new WrongSizedLottoNumberException(
                    String.format("로또 번호는 %d개의 숫자로 이루어져야 합니다.", LOTTO_NUMBER_COUNT), numbers);
        }
    }

    private void validateNoDuplicate(int[] numbers) {
        if (hasDuplicate(numbers)) {
            throw new DuplicateLottoNumberException(numbers);
        }
    }

    private boolean hasDuplicate(int[] numbers) {
        int lengthWithoutDuplicate = (int) Arrays.stream(numbers)
                .distinct()
                .count();
        return numbers.length != lengthWithoutDuplicate;
    }
}
