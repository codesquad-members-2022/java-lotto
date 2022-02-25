package domain;

import java.util.Map;

public class ProfitCalculator {

    private int purchasingAmount;
    private Map<Rank,Integer> winningResult;

    public ProfitCalculator(int purchasingAmount, Map<Rank,Integer> winningResult) {
        this.purchasingAmount = purchasingAmount;
        this.winningResult = winningResult;
    }

    public double calculate() {
        double totalWinningPrice = getTotalWinningPrice();
        return ((totalWinningPrice /  purchasingAmount) * 100 - 100);
    }

    private int getTotalWinningPrice() {
        int totalWinningPrice = 0;
        for (Rank rank : Rank.values()) {
            totalWinningPrice += rank.getWinningMoney() * winningResult.get(rank);
        }
        return totalWinningPrice;
    }
}
