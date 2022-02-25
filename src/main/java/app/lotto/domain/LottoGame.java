package app.lotto.domain;

import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private final LottoGameDto lottoGameDto;
    private final int amount;

    private LottoGame(LottoGameDto lottoGameDto, int amount) {
        this.lottoGameDto = lottoGameDto;
        this.amount = amount;
    }

    public static LottoGame createWithLottoGameDtoAndAmount(LottoGameDto lottoGameDto, int amount) {
        return new LottoGame(lottoGameDto, amount);
    }

    public void printLottoGameResult() {
        List<LottoResult> lottoResults = processLottoGame(lottoGameDto);
        long totalProfit = getTotalProfit(lottoResults);
        double result = (totalProfit - this.amount) / (double) this.amount * 100.0;

        OutputView.printWinStatistics(lottoResults);
        OutputView.printTotalProfit(result);
    }

    private List<LottoResult> processLottoGame(LottoGameDto lottoGameDto) {
        Map<LottoPrize, Integer> statistics = PrizeCounter.getStatistics(lottoGameDto);
        return getLottoResults(statistics);
    }

    private long getTotalProfit(List<LottoResult> lottoResults) {
        long totalProfit = 0;
        for (LottoResult result : lottoResults) {
            totalProfit += (result.getLottoPrize().getPrizeMoney() * result.getWinningCaseCount());
        }
        return totalProfit;
    }

    private List<LottoResult> getLottoResults(Map<LottoPrize, Integer> statistics) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoResults.add(getLottoResult(statistics, lottoPrize));
        }
        return lottoResults;
    }

    private LottoResult getLottoResult(Map<LottoPrize, Integer> statistics, LottoPrize lottoPrize) {
        int winningCaseCount = statistics.getOrDefault(lottoPrize, 0);

        return new LottoResult(lottoPrize, winningCaseCount);
    }
}
