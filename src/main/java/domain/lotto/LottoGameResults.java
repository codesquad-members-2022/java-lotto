package domain.lotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class LottoGameResults {

    private final double returnToInvestment;

    private final Map<Rank, Integer> rankCounts;

    public LottoGameResults(LottoTickets lottoTickets, WinningTicket winningTicket) {

        this.rankCounts = setupRankCounts(lottoTickets, winningTicket);
        returnToInvestment = calculateReturnToInvestment(lottoTickets);
    }

    private Map<Rank, Integer> setupRankCounts(LottoTickets lottoTickets, WinningTicket winningTicket) {
        Map<Rank, Integer> rankCounts = initRankCounts();
        calculateRankCounts(rankCounts, lottoTickets, winningTicket);
        return rankCounts;
    }

    private Map<Rank, Integer> initRankCounts() {
        Map<Rank, Integer> rankCounts = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounts.put(rank, 0);
        }
        return rankCounts;
    }

    private void calculateRankCounts(Map<Rank, Integer> rankCounts, LottoTickets lottoTickets, WinningTicket winningTicket) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        for (LottoTicket ticket : tickets) {
            Rank resultRank = winningTicket.match(ticket);
            rankCounts.put(resultRank, rankCounts.get(resultRank) + 1);
        }
    }

    public double getReturnToInvestment() {
        return returnToInvestment;
    }

    private double calculateReturnToInvestment(LottoTickets lottoTickets) {
        long totalRewards = getTotalRewards();
        double profit = totalRewards - lottoTickets.getPriceSum();
        double returnOfInvestment = (profit) / lottoTickets.getPriceSum() * 100;
        return returnOfInvestment;
    }

    private long getTotalRewards() {
        return Stream.of(Rank.values())
                .mapToLong(this::getRankReward)
                .sum();
    }

    private long getRankReward(Rank rank) {
        long rankReward = rank.getReward();
        return rankReward * getRankCountOf(rank);
    }

    public int getRankCountOf(Rank rank) {
        return rankCounts.get(rank);
    }
}
