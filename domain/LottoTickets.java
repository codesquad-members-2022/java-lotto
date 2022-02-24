package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_HUNDRED = 100;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int winningAmount(Map<Rank, Integer> answers) {
        int sum = 0;
        for (Rank rank : answers.keySet()) {
            int winningPrize = rank.getWinningPrize().getValue();
            int count = answers.getOrDefault(rank, DEFAULT_VALUE);
            sum += winningPrize * count;
        }
        return sum;
    }

    public double calculateYield(int sum, int inputMoney) {
        double yield = (sum - inputMoney) * ONE_HUNDRED / inputMoney;
        return Math.round(yield * ONE_HUNDRED) / ONE_HUNDRED;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}