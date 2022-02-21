package lotto_game;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStatistics {
    private Map<Integer, Integer> store = new HashMap<>() {{
        put(3, 0);
        put(4, 0);
        put(5, 0);
        put(6, 0);
    }};

    public Map<Integer, Integer> winCount() {
        return store;
    }
    public String IncomeRate(String inputWinNumber, Lottos lottos) {
        List<Integer> winNumber = stringToIntList(inputWinNumber);
        List<Lotto> lotto = lottos.getLottos();
        int sum = 0;
        for (int i = 0; i < lotto.size(); i++) {
            int collectCount = 0;
            for (int j = 0; j < winNumber.size(); j++) {
                if (lotto.get(i).getLottoNumbers().contains(winNumber.get(j))) {
                    collectCount++;
                }
            }
            sum += getWinMoney(collectCount);
        }
        return getWinMoneyRate(sum, lotto.size() * 1000);
    }

    private String getWinMoneyRate(int sum, int price) {
        if (sum == 0) {
            return "-100.0";
        }
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format((sum - price) / price * 100);
    }

    private int getWinMoney(int collectCount) {
        if (collectCount == 3) {
            store.put(3, store.get(3) + 1);
            return Reward.THREE_NUMBER_MATCH.getWinningMoney();
        }
        if (collectCount == 4) {
            store.put(4, store.get(4) + 1);
            return Reward.FOUR_NUMBER_MATCH.getWinningMoney();
        }
        if (collectCount == 5) {
            store.put(5, store.get(5) + 1);
            return Reward.FIVE_NUMBER_MATCH.getWinningMoney();
        }
        if (collectCount == 6) {
            store.put(6, store.get(6) + 1);
            return Reward.SIX_NUMBER_MATCH.getWinningMoney();
        }
        return 0;
    }

    private List<Integer> stringToIntList(String inputWinNumber) {
        String[] split = inputWinNumber.split(",");
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        return list;
    }
}
