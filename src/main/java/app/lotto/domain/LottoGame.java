package app.lotto.domain;

import app.lotto.view.LottoResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public static List<LottoResult> processLottoGame(LottoGameResult lottoGameResult) {
        Map<LottoPrize, Integer> statistics = getStatistics(lottoGameResult);
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

    private static Map<LottoPrize, Integer> getStatistics(LottoGameResult lottoGameResult) {
        Map<LottoPrize, Integer> statistics = new HashMap<>();

        List<LottoTicket> allLottoTicket = new ArrayList<>();
        allLottoTicket.addAll(lottoGameResult.getAllAutoLottoNumbers());
        allLottoTicket.addAll(lottoGameResult.getCustomLottoNumbers());

        for (LottoTicket lottoTicket : allLottoTicket) {
            int sameNumberCount = getSameNumberCount(lottoTicket, lottoGameResult.getWinningNumbers());
            boolean isBonus = lottoTicket.contains(lottoGameResult.getBonusNumber());

            addCountToStatistics(statistics, sameNumberCount, isBonus);
        }
        return statistics;
    }

    private static void addCountToStatistics(Map<LottoPrize, Integer> statistics, int sameNumberCount, boolean isBonus) {
        if (LottoPrize.isLottoPrize(sameNumberCount)) {
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(sameNumberCount, isBonus)
                    .orElseThrow(() -> new IllegalStateException("당첨 여부 확인 중 오류가 발생하였습니다."));
            int value = statistics.getOrDefault(lottoPrize, 0);
            value++;
            statistics.put(lottoPrize, value);
        }
    }

    private static int getSameNumberCount(LottoTicket shuffledNumbers, LottoTicket winningNumbers) {
        int count = 0;

        for (int i = 0; i < shuffledNumbers.getSize(); i++) {
            count = getCount(winningNumbers, count, shuffledNumbers.getNumber(i));
        }

        return count;
    }

    private static int getCount(LottoTicket winningNumbers, int count, int number) {
        if (winningNumbers.contains(number)) {
            count++;
        }
        return count;
    }

}
