package model;

import view.InputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());

    public void buildLotto() {
        price = Integer.parseInt(InputView.requestPrice());
        count = price / LOTTO_PRICE;

        while (lottoList.size() != count) {
            Set<Integer> numbers = new HashSet<>();
            while (numbers.size() != 6) {
                Collections.shuffle(range);
                numbers.add(range.get(0));
            }
            List<Integer> lists = new ArrayList<>(numbers);
            for (Lotto lotto : lottoList) {
                if (!lotto.sameList(lists)) {
                    lottoList.add(new Lotto(numbers));
                    break;
                }
            }
        }
        for (Lotto lotto : lottoList) {
            List<Integer> numbers = lotto.getNumbers();
            for (Integer number : numbers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }

    }

}

