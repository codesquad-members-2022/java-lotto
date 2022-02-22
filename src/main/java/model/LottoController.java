package model;

import com.sun.jdi.Value;
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

    static {
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
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
        OutputView.printPurchaseCount(count, lottoList);
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
        rateOfReturn();
    }

    private void rateOfReturn() {
        int revenue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            revenue += ValueMap.valueMap.get(entry.getKey()) * entry.getValue();
        }
        double temp = (double) (revenue - price) / (price) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(temp);

        OutputView.printResult(map, result);
    }
}
