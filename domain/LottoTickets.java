package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Map;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private static final int DEFAULT_VALUE = 0;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public Money getWinningPrize(Map<Rank, Integer> answers) {
        Money sum = Money.ZERO;
        for (Rank rank : answers.keySet()) {
            Money winningPrize = rank.getWinningPrize();
            int count = answers.getOrDefault(rank, DEFAULT_VALUE);
            sum = sum.add(winningPrize.multiply(count));
        }
        return sum;
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}