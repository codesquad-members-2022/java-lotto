package PACKAGE_NAME.domain;

import java.util.Map;

public class RateOfReturnCalculator {

    public double calculateRateOfReturn(LottoTickets lottoTickets, Map<Rank, Integer> answers) {
        int winningPrize = lottoTickets.getWinningPrize(answers);
        int purchaseAmount = lottoTickets.getLottoTickets().size() * 1000;
        return calculateRateOfReturn(winningPrize, purchaseAmount);
    }

    private double calculateRateOfReturn(int sum, int inputMoney) {
        double rateOfReturn = (sum - inputMoney) * 100 / inputMoney;
        return Math.round(rateOfReturn * 100) / 100;
    }
}
