package PACKAGE_NAME.domain;

import java.util.Map;
import java.util.Objects;

import static java.lang.Math.round;

public class RateOfReturn {

    private final Map<Rank, Integer> answer;
    private final LottoTickets lottoTickets;
    private final double rateOfReturn;

    public RateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        this.answer = ranksResult;
        this.lottoTickets = lottoTickets;
        this.rateOfReturn = getRateOfReturn(ranksResult, lottoTickets);
    }

    private double getRateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        return calculateRateOfReturn(ranksResult, lottoTickets);
    }

    private double calculateRateOfReturn(Map<Rank, Integer> ranksResult, LottoTickets lottoTickets) {
        Money winningPrize = lottoTickets.getWinningPrize(ranksResult);
        int purchaseAmount = lottoTickets.getLottoTickets().size() * 1000;
        return calculateRateOfReturn(winningPrize, purchaseAmount);
    }

    private double calculateRateOfReturn(Money sum, int inputMoney) {
        double rateOfReturn = (double) (sum.getValue() - inputMoney) * 100 / inputMoney;
        return (double) round(rateOfReturn * 100) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RateOfReturn that = (RateOfReturn) o;
        return Double.compare(that.rateOfReturn, rateOfReturn) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rateOfReturn);
    }

    @Override
    public String toString() {
        return rateOfReturn+"";
    }
}


