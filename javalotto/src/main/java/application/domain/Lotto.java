package application.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lotto {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int AMOUNT_LOTTO_NUMBER = 6;

    public static List<Integer> createNumbers() {
        return new Random(System.currentTimeMillis())
                .ints(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .distinct()
                .limit(AMOUNT_LOTTO_NUMBER)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return new ArrayList<>();
    }
}
