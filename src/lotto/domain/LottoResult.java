package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoResult {
    private final Map<PrizeDivision, Integer> winnersPerPrize = new EnumMap<>(PrizeDivision.class);
    private final int paidAmount;

    public LottoResult(LottoBundle lottoBundle, LottoTicket winningTicket) {
        this.paidAmount = lottoBundle.getPaidAmount();
        countWinnersPerPrize(lottoBundle, winningTicket);
    }

    public int getWinnerCount(PrizeDivision division) {
        return winnersPerPrize.getOrDefault(division, 0);
    }

    public double getProfitRate() {
        int sum = Stream.of(lotto.domain.PrizeDivision.values())
                .map(d -> d.getPrizeValue() * winnersPerPrize.getOrDefault(d, 0))
                .reduce(0, Math::addExact);
        return (double) (sum - paidAmount) / paidAmount * 100;
    }

    private void countWinnersPerPrize(LottoBundle lottoBundle, LottoTicket winningTicket) {
        IntStream.range(0, lottoBundle.count())
                .mapToObj(lottoBundle::getTicket)
                .mapToInt(t -> t.matchNumbers(winningTicket))
                .mapToObj(PrizeDivision::getWhichDivision)
                .forEach(this::incrementWinnerCount);
    }

    private void incrementWinnerCount(PrizeDivision division) {
        if (division == null) {
            return;
        }

        int count = winnersPerPrize.getOrDefault(division, 0);
        winnersPerPrize.put(division, count + 1);
    }

}
