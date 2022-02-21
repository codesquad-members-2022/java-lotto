package model;

import view.InputView;
import view.OutputView;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private Map<Integer, Integer> map = new HashMap<>();
    // key : 3, 4, 5, 6
    // value : 3? 4? 5? 6?

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
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", "); // 1,2,3,4,5,6
        // TODO : 당첨 통계 구현 필요
    }
}

