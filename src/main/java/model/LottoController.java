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
    private final List<Lotto> lottoList = new ArrayList<>();
    private final List<Integer> range = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
    private static final Map<Integer, Integer> map = new HashMap<>();

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
            makeRandomNumberSet(numbers);
            checkOverLap(new ArrayList<>(numbers));
        }
        OutputView.printPurchaseCount(count, lottoList);
    }

    private void checkOverLap(List<Integer> lists) {
        int size = lottoList.stream()
                .filter(l -> l.sameList(lists))
                .collect(Collectors.toList())
                .size();
        sortingNumber(lists, size);
    }

    private void sortingNumber(List<Integer> lists, int size) {
        if (size == 0) {
            Collections.sort(lists);
            lottoList.add(new Lotto(lists));
        }
    }

    private void makeRandomNumberSet(Set<Integer> numbers) {
        while (numbers.size() != 6) {
            Collections.shuffle(range);
            numbers.add(range.get(0));
        }
    }

    public void checkWinNumber() {
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", ");
        for (Lotto lotto : lottoList) {
            countHowManyLotto(winNumbers, lotto);
        }
        rateOfReturn();
    }

    private void countHowManyLotto(String[] winNumbers, Lotto lotto) {
        int tempCount = lotto.countCollectNumber(winNumbers);
        if (tempCount >= 3) {
            map.put(tempCount, map.get(tempCount) + 1);
        }
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
