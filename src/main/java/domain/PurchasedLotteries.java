package domain;

import java.util.List;

public class PurchasedLotteries {

    private final List<Lotto> purchasedLotteries;

    public PurchasedLotteries(List<Lotto> purchasedLotteries) {
        this.purchasedLotteries = purchasedLotteries;
    }

    public Result getResult(WinningNumbers winningNumbers) {
        return Result.compute(this, winningNumbers);
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
