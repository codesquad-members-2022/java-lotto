package lotto.domain;

import static lotto.validate.Validator.isValidLottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    public static final int PRICE = 1000;
    private static final List<Integer> allNumbers = IntStream.rangeClosed(1, 45).boxed()
        .collect(Collectors.toList());

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) throws IllegalArgumentException {
        isValidLottoNumbers(numbers);
        this.numbers = new ArrayList<>(numbers);
        Collections.sort(this.numbers);
    }

    public static Lotto create() throws IllegalArgumentException {
        Collections.shuffle(allNumbers);
        return new Lotto(allNumbers.subList(0, 6));
    }

    public static Lotto create(List<Integer> lottoNumbers) throws IllegalArgumentException {
        return new Lotto(lottoNumbers);
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getNumbers() {
        return Collections.unmodifiableList(numbers);
    }
}
