package model;

import view.InputView;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> list = new ArrayList<>();
    private List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());


    public void buildLotto() {
        price = Integer.parseInt(InputView.requestPrice());
        count = price / LOTTO_PRICE;

        while (true) {
            Set<Integer> numbers = new HashSet<>();
            while (numbers.size() != 6) {
                Collections.shuffle(range);
                numbers.add(range.get(0));
            }
            ArrayList<Integer> lists = new ArrayList<>(numbers);
            list.add(new Lotto(numbers));
        }

    }

}

