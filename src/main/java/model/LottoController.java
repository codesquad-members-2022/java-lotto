package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
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
    private static final int BONUS_COUNT = 7;
    private static final int BONUS_TARGET_COUNT = 5;

    private final List<Integer> range = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
        .boxed()
        .collect(Collectors.toList());
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> map;
    private int price;

    public LottoController(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.map = new LinkedHashMap<>();
        initMap();
    }

    private void initMap() {
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(BONUS_COUNT, 0);
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

    private void makeRandomNumberSet(Set<Integer> numbers) {
        while (numbers.size() != MAX_NUMBER_COUNT) {
            Collections.shuffle(range);
            numbers.add(range.get(0));
        }
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

    public void checkWinNumber() {
        String winNumber = InputView.requestWinNumber();
        String[] winNumbers = winNumber.split(", ");
        String bonusNumber = InputView.requestBonusNumber();
        for (Lotto lotto : lottoList) {
            countMatchLotto(winNumbers, lotto, bonusNumber);
        }
        rateOfReturn();
        InputView.ScannerClose();
    }

    private void countMatchLotto(String[] winNumbers, Lotto lotto, String bonusNumber) {
        int tempCount = lotto.countCollectNumber(winNumbers);
        if (tempCount == BONUS_TARGET_COUNT && lotto.hasBonusNumber(bonusNumber)) {
            map.put(BONUS_COUNT, map.get(BONUS_COUNT) + 1);
            return;
        }
        if (tempCount >= MIN_WINNING_NUMBER) {
            map.put(tempCount, map.get(tempCount) + 1);
        }
    }

    private void rateOfReturn() {
        int revenue = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            revenue += CollectCalculator.getCalculator(entry.getKey(), entry.getValue());
        }
        double temp = (double)(revenue - price) / (price) * 100;
        DecimalFormat df = new DecimalFormat("0.00");
        String result = df.format(temp);
        OutputView.printResult(map, result);
    }
}
