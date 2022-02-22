package domain.lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RewardMachine {

    private final Money money;
    private final LottoTickets lottoTickets;
    private final WinningTicket winningTicket;
    private final Map<Rank, Integer> rankCounts;

    public RewardMachine(Money money, LottoTickets lottoTickets, WinningTicket winningTicket) {
        this.money = money;
        this.lottoTickets = lottoTickets;
        this.winningTicket = winningTicket;
        this.rankCounts = setupRankCounts();
    }

    public Map<Rank, Integer> getRankCounts() {
        return Collections.unmodifiableMap(rankCounts);
    }

    private Map<Rank, Integer> setupRankCounts() {
        Map<Rank, Integer> rankCounts = initRankCounts();
        calculateRankCounts(rankCounts);
        return rankCounts;
    }

    private Map<Rank, Integer> initRankCounts() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void calculateRankCounts(Map<Rank, Integer> rankCounts) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket ticket : tickets) {
            Rank resultRank = winningTicket.match(ticket);
            rankCounts.put(resultRank, rankCounts.get(resultRank) + 1);
        }
    }
}
