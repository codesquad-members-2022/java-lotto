package domain;

import java.util.LinkedHashMap;

public class ProfitCalculator {

    private int purchasingAmount;
    private LinkedHashMap<Rank,Integer> winningResult;

    public ProfitCalculator(int purchasingAmount, LinkedHashMap<Rank,Integer> winningResult) {
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
