package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {

    private List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }

    public int check(int[] winingNumber) {
        int count = 0;

        for (int index = 0; index < winingNumber.length; index++) {
            count += countContainNumber(winingNumber, index);
        }

        return count;
    }

    private int countContainNumber(int[] winingNumber, int index) {
        int count = 0;

        if (numbers.contains(winingNumber[index])) {
            count++;
        }

        return count;
    }

    @Override
    public String toString() {
        return numbers + "";
    }
}
