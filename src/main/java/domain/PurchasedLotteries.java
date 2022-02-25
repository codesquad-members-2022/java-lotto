package domain;

import java.util.List;

import domain.Lotto.Lotto;

public class PurchasedLotteries {

    private final List<Lotto> purchasedLotteries;

    public PurchasedLotteries(List<Lotto> purchasedLotteries) {
        this.purchasedLotteries = purchasedLotteries;
    }

    public Result getResult(WinningNumbers winningNumbers) {
        return Result.compute(this, winningNumbers);
    }

    public int getTotalInvestment() {
        return Lotto.PRICE * countAllLotto();
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

    public int countAllLotto() {
        return purchasedLotteries.size();
    }

    public int countTypeOf(Class<? extends Lotto> lottoType) {
        return (int)purchasedLotteries.stream()
            .filter(lottoType::isInstance)
            .count();
    }

    public List<Lotto> get() {
        return List.copyOf(purchasedLotteries);
    }
}
