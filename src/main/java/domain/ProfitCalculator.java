package domain;

import java.util.HashMap;

public class ProfitCalculator {

    public static HashMap<Integer, Integer> winningPriceTable;

    private int purchasingAmount;
    private int[] winningResult;

    public ProfitCalculator(int purchasingAmount, int[] winningResult) {
        this.purchasingAmount = purchasingAmount;
        this.winningResult = winningResult;
        winningPriceTable = new HashMap<>() {{
            put(3, 5_000);
            put(4, 50_000);
            put(5, 1_500_000);
            put(6, 2_000_000_000);
        }};
    }

    public double calculate() {
        double totalWinningPrice = getTotalWinningPrice();
        return ((totalWinningPrice /  purchasingAmount) * 100 - 100);
    }

    private int getTotalWinningPrice() {
        int totalWinningPrice = 0;
        for (int key : winningPriceTable.keySet()) {
            totalWinningPrice += winningPriceTable.get(key) * winningResult[key];
        }
        return totalWinningPrice;
    }
}
