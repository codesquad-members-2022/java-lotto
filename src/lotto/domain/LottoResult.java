package lotto.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoResult {
    private final LottoBundle lottoBundle;
    private final WinningNumber winningNumber;
    private final Map<PrizeDivision, Integer> winnersPerPrize = new EnumMap<>(PrizeDivision.class);

    private LottoResult(LottoBundle lottoBundle, WinningNumber winningNumber) {
        this.lottoBundle = lottoBundle;
        this.winningNumber = winningNumber;
    }

    public static LottoResult of(LottoBundle lottoBundle, WinningNumber winningNumber) {
        LottoResult result = new LottoResult(lottoBundle, winningNumber);
        result.countWinnersPerPrize();

        return result;
    }

    public int getWinnerCount(PrizeDivision division) {
        return winnersPerPrize.getOrDefault(division, 0);
    }

    public double getProfitRate() {
        int sum = Stream.of(PrizeDivision.values())
                .map(d -> d.getPrizeValue() * winnersPerPrize.getOrDefault(d, 0))
                .reduce(0, Math::addExact);
        int paidAmount = lottoBundle.getPaidAmount();

        return (double) (sum - paidAmount) / paidAmount * 100;
    }

    private void countWinnersPerPrize() {
        IntStream.range(0, lottoBundle.count())
                .mapToObj(lottoBundle::getTicket)
                .map(winningNumber::evaluateTicket)
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
