package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public int check(List<Integer> winingNumber) {
        int count = 0;

        for (int index = 0; index < winingNumber.size(); index++) {
            count += countContainNumber(winingNumber, index);
        }

        return count;
    }

    private int countContainNumber(List<Integer> winingNumber, int index) {
        int count = 0;

        if (numbers.contains(winingNumber.get(index))) {
            count++;
        }

        return count;
    }

    public boolean isMatchBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers + "";
    }

}
