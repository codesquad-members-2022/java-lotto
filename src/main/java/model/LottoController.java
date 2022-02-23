package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import view.InputView;
import view.OutputView;

public class LottoController {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_NUMBER_COUNT = 6;
    private static final int MIN_WINNING_NUMBER = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private final List<Integer> range = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER).boxed().collect(Collectors.toList());

    private final List<Lotto> lottoList;
    private Map<Integer, Integer> map;
    private int price;

    public LottoController(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        initMap();
    }

    private void initMap() {
        map = new HashMap<>();
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(6, 0);
    }

    public void buildLotto() {
        price = Integer.parseInt(InputView.requestPrice());
        int count = price / LOTTO_PRICE;

        while (lottoList.size() != count) {
            Set<Integer> numbers = new HashSet<>();
            makeRandomNumberSet(numbers);
            checkOverLap(new ArrayList<>(numbers));
        }
        OutputView.printPurchaseCount(count, lottoList);
    }

    private void checkOverLap(List<Integer> lists) {
        int size = (int)lottoList.stream()
            .filter(l -> l.sameList(lists)).count();
        sortingNumber(lists, size);
    }

    private void sortingNumber(List<Integer> lists, int size) {
        if (size == 0) {
            Collections.sort(lists);
            lottoList.add(new Lotto(lists));
        }
    }

    private void makeRandomNumberSet(Set<Integer> numbers) {
        while (numbers.size() != MAX_NUMBER_COUNT) {
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
        String bonusNumber = InputView.requestBonusNumber();

    }

    private void countHowManyLotto(String[] winNumbers, Lotto lotto) {
        int tempCount = lotto.countCollectNumber(winNumbers);
        if (tempCount >= MIN_WINNING_NUMBER) {
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
