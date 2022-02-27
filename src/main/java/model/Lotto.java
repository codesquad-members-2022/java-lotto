package model;

import java.util.Arrays;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean sameList(List<Integer> lists) {
        return numbers.containsAll(lists);
    }

    public int countCollectNumber(String[] winNumbers) {
        return (int)Arrays.stream(winNumbers)
            .map(Integer::parseInt)
            .filter(numbers::contains).count();
    }

    public boolean hasBonusNumber(String bonusNumber) {
        return numbers.contains(Integer.parseInt(bonusNumber));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
