package PACKAGE_NAME.domain;

import java.util.Map;

public class RateOfReturn {

    private Map<Rank, Integer> answer;
    private LottoTickets lottoTickets;
    private double rateOfReturn;

    public RateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        this.answer = ranksResult;
        this.lottoTickets = lottoTickets;
        this.rateOfReturn = getRateOfReturn(ranksResult, lottoTickets);
    }

    private double getRateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        return calculateRateOfReturn(ranksResult, lottoTickets);
    }

    private double calculateRateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        int winningPrize = lottoTickets.getWinningPrize(ranksResult);
        int purchaseAmount = lottoTickets.getLottoTickets().size() * 1000;
        return calculateRateOfReturn(winningPrize, purchaseAmount);
    }

    private double calculateRateOfReturn(int sum, int inputMoney) {
        double rateOfReturn = (sum - inputMoney) * 100 / inputMoney;
        return Math.round(rateOfReturn * 100) / 100;
    }

    @Override
    public String toString() {
        return rateOfReturn+"";
    }
}


