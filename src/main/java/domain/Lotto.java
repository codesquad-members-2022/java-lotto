package domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    protected static final int LOTTO_SIZE = 6;
    protected final List<Integer> numbers;

    protected Lotto(List<Integer> numbers) {
        this.numbers = numbers;
        sort();
    }

    private void sort() {
        Collections.sort(numbers);
    }
}
