package app.lotto.view;

import app.lotto.domain.LottoPrize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void winStatistics(List<List<Integer>> allShuffledNumbers, List<Integer> winningNumbers, int amount, int bonusNumber) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Map<LottoPrize, Integer> statistics = getStatistics(allShuffledNumbers, winningNumbers, bonusNumber);

        List<LottoResult> lottoResults = getLottoResults(statistics);

        long totalWinAmount = getTotalWinAmount(lottoResults);
        double result = (totalWinAmount - amount) / (double) amount * 100.0;

        System.out.printf("총 수익률은 %.2f%%입니다.", result);
    }

    private static long getTotalWinAmount(List<LottoResult> lottoResults) {
        long totalWinAmount = 0;
        for (LottoResult lottoResult : lottoResults) {
            totalWinAmount += lottoResult.getWinAmount();
            System.out.printf("%d개 일치 (%d원) - %d개\n", lottoResult.getCount(), lottoResult.getPrizeMoney(), lottoResult.getWinningCaseCount());
        }
        return totalWinAmount;
    }

    private static List<LottoResult> getLottoResults(Map<LottoPrize, Integer> statistics) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoResults.add(getLottoResult(statistics, lottoPrize, lottoPrize.getPrizeMoney()));
        }
        return lottoResults;
    }

    private static LottoResult getLottoResult(Map<LottoPrize, Integer> statistics, LottoPrize lottoPrize, long prizeMoney) {
        int winningCaseCount = statistics.getOrDefault(lottoPrize, 0);

        return new LottoResult.Builder()
                .setStatistics(statistics)
                .setCount(lottoPrize.getCount())
                .setWinningCaseCount(winningCaseCount)
                .setPrizeMoney(prizeMoney)
                .setWinAmount(prizeMoney * winningCaseCount)
                .build();
    }

    private static Map<LottoPrize, Integer> getStatistics(List<List<Integer>> allShuffledNumbers, List<Integer> winningNumbers, int bonusNumber) {
        Map<LottoPrize, Integer> statistics = new HashMap<>();

        for (List<Integer> shuffledNumber : allShuffledNumbers) {
            int sameNumberCount = getSameNumberCount(shuffledNumber, winningNumbers);
            boolean isBonus = shuffledNumber.contains(bonusNumber);
            if (!LottoPrize.isLottoPrize(sameNumberCount, isBonus)) continue;
            LottoPrize lottoPrize = LottoPrize.findLottoPrize(sameNumberCount, isBonus)
                    .orElseThrow(() -> new IllegalStateException("당첨 여부 확인 중 오류가 발생하였습니다."));
            int value = statistics.getOrDefault(lottoPrize, 0);
            value++;
            statistics.put(lottoPrize, value);
        }
        return statistics;
    }

    private static int getSameNumberCount(List<Integer> shuffledNumbers, List<Integer> winningNumbers) {
        int count = 0;

        for (int number : shuffledNumbers) {
            count = getCount(winningNumbers, count, number);
        }
        return count;
    }

    private static int getCount(List<Integer> winningNumbers, int count, int number) {
        if (winningNumbers.contains(number)) {
            count++;
        }
        return count;
    }
}
