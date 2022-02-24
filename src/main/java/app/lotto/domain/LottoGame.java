package app.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public static List<LottoResult> processLottoGame(LottoGameResult lottoGameResult) {
        Map<LottoPrize, Integer> statistics = PrizeCounter.getStatistics(lottoGameResult);
        return getLottoResults(statistics);
    }

    public static long getTotalProfit(List<LottoResult> lottoResults) {
        long totalProfit = 0;
        for (LottoResult result : lottoResults) {
            totalProfit += (result.getLottoPrize().getPrizeMoney() * result.getWinningCaseCount());
        }
        return totalProfit;
    }

    private static List<LottoResult> getLottoResults(Map<LottoPrize, Integer> statistics) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoResults.add(getLottoResult(statistics, lottoPrize));
        }
        return lottoResults;
    }

    private static LottoResult getLottoResult(Map<LottoPrize, Integer> statistics, LottoPrize lottoPrize) {
        int winningCaseCount = statistics.getOrDefault(lottoPrize, 0);

        return new LottoResult(lottoPrize, winningCaseCount);
    }
}
