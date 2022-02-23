package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PurchasedLotteries {

    private final List<Lotto> purchasedLotteries;

    public PurchasedLotteries(List<Lotto> purchasedLotteries) {
        this.purchasedLotteries = purchasedLotteries;
    }

    public Map<Rank, Integer> getResult(WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.rank1, 0);
        result.put(Rank.rank2, 0);
        result.put(Rank.rank3, 0);
        result.put(Rank.rank4, 0);
        result.put(Rank.rank5, 0);
        result.put(Rank.noRank, 0);

        for (Lotto purchasedLottery : purchasedLotteries) {
            Rank rank = purchasedLottery.getMatchedRank(winningNumbers);
            result.replace(rank, result.get(rank) + 1);
        }
        return result;
    }

    public int getTotalInvestment() {
        return Lotto.PRICE * count();
    }

    public int getTotalPrize(WinningNumbers winningNumbers) {
        return purchasedLotteries.stream()
            .mapToInt(lotto -> lotto.getMatchedRank(winningNumbers).getPrize())
            .sum();
    }

    public float getProfitRate(WinningNumbers winningNumbers) {
        return ((float)getTotalPrize(winningNumbers) - getTotalInvestment()) / getTotalInvestment()
            * 100;
    }

    public int count() {
        return purchasedLotteries.size();
    }

    public List<Lotto> get() {
        return List.copyOf(purchasedLotteries);
    }
}
