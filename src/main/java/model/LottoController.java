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
            boolean overLapCheck = false;
            for (Lotto lotto : lottoList) {
                if (lotto.sameList(lists)) {
                    overLapCheck = true;
                    break;
                }
            }
            if (!overLapCheck) {
                Collections.sort(lists);
                lottoList.add(new Lotto(lists));
            }


        }

    }

    public void checkWinNumber() {
        InputView.requestWinNumber();
    }
}

