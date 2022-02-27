package domain;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private final Map<Rank, Integer> result;

    private Result(Map<Rank, Integer> result) {
        this.result = result;
    }

    public static Result compute(PurchasedLotteries purchasedLotteries,
        WinningNumbers winningNumbers) {
        Map<Rank, Integer> resultMap = initResultMap();
        for (Lotto purchasedLottery : purchasedLotteries.get()) {
            Rank rank = purchasedLottery.getMatchedRank(winningNumbers);
            resultMap.replace(rank, resultMap.get(rank) + 1);
        }
        return new Result(resultMap);
    }

    private static Map<Rank, Integer> initResultMap() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
        return result;
    }

    public int getCount(Rank rank) {
        return result.get(rank);
    }
}
