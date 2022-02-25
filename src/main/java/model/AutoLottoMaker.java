package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AutoLottoMaker implements LottoMaker {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final List<Integer> range = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());

    @Override
    public List<Integer> createLotto() {
        Collections.shuffle(range);
        return new ArrayList<>(range.subList(0, 6));
    }
}
