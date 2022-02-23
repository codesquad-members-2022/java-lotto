package domain;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class LottoGenerator {

    static final int LOTTO_NUMBER_MIN = 1;
    static final int LOTTO_NUMBER_MAX = 45;
    static final int LOTTO_NUMBER_SIZE = 7;
    private List<Integer> shuffledNumbers = new ArrayList<>();

    public LottoGenerator() {
        createShuffledNumbers();
    }

    private void createShuffledNumbers() {
        for (int i = LOTTO_NUMBER_MIN; i <= LOTTO_NUMBER_MAX; i++) {
            shuffledNumbers.add(i);
        }
    }

    private void shuffle() {
        Collections.shuffle(shuffledNumbers);
    }

    public List<Integer> getNumbers() {
        shuffle();
        return shuffledNumbers.subList(0, LOTTO_NUMBER_SIZE);
    }
}
