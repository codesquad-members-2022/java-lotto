package model;

import view.InputView;
import view.OutputView;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoController {
    private int price;
    private static final int LOTTO_PRICE = 1000;
    private int count;
    private List<Lotto> lottoList = new ArrayList<>();
    private List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static Map<Integer, Integer> map = new HashMap<>();
    private static Map<Integer, Long> valueMap = new HashMap<>();
    // key : 3, 4, 5, 6
    // value : 3? 4? 5? 6?

    static {
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);

        valueMap.put(3, 5000L);
        valueMap.put(4, 50000L);
        valueMap.put(5, 1500000L);
        valueMap.put(6, 2000000000L);
    }

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
        //Test
        for (Lotto lotto : lottoList) {
            for (Integer number : lotto.getNumbers()) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public void checkWinNumber() {
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", ");

        for (Lotto lotto : lottoList) {
            int count = lotto.countCollectNumber(winNumbers);
            if (count >= 3) {
                map.put(count, map.get(count) + 1);
            }
        }
        //Test
        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            Integer integer1 = map.get(integer);
            System.out.println(integer1);
        }

        rateOfReturn();
    }

    private void rateOfReturn() {
        int revenue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            revenue += valueMap.get(entry.getKey()) * entry.getValue();
        }
        double temp = (double) (revenue - price) / (price) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(df);

        OutputView.printResult(map, result);
    }
}
