package model;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import view.OutputView;

public class LottoRepository {
    private static final int MIN_WINNING_NUMBER = 3;
    private static final int BONUS_COUNT = 7;
    private static final int BONUS_TARGET_COUNT = 5;
    private final List<Lotto> lottoList;
    private final Map<Integer, Integer> map;

    public LottoRepository(List<Lotto> lottoList) {
        this.lottoList = lottoList;
        this.map = new LinkedHashMap<>();
        initMap();
    }

    private void initMap() {
        map.put(3, 0);
        map.put(4, 0);
        map.put(5, 0);
        map.put(7, 0);
        map.put(6, 0);
    }


    public void checkOverLap(List<Integer> lists) {
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

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public void checkWinNumber(String[] winNumbers, String bonusNumber, int price) {
        for (Lotto lotto : getLottoList()) {
            countMatchLotto(winNumbers, lotto, bonusNumber);
        }
        rateOfReturn(price);
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

    private void rateOfReturn(int price) {
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
