package domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LottoGenerator {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;
    static final int LOTTO_NUMBER_SIZE = 6;
    private static List<Integer> shuffledNumbers = new ArrayList<>();

    static {
        createShuffledNumbers();
    }

    private static void createShuffledNumbers() {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            shuffledNumbers.add(i);
        }
    }

    private static void shuffle() {
        Collections.shuffle(shuffledNumbers);
    }

    public static List<Integer> getNumbers() {
        shuffle();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <LOTTO_NUMBER_SIZE; i++) {
            numbers.add(shuffledNumbers.get(i));
        }
        return numbers;
    }
}
