package application.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lottery {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    public static final int COUNT = 6;

    private static final List<Integer> candidates;
    protected final List<Integer> numbers;


    static {
        candidates = new ArrayList<>();

        IntStream.rangeClosed(MIN_NUM, MAX_NUM)
            .forEach(candidates::add);
    }

    public Lottery() {
        numbers = new ArrayList<>();
        Collections.shuffle(candidates);

        numbers.addAll(candidates.subList(0, COUNT));
    }

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
