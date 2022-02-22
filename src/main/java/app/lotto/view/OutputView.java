package app.lotto.view;

import app.lotto.domain.LottoPrize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {

    public static void winStatistics(List<List<Integer>> allShuffledNumbers, List<Integer> winningNumbers, int amount) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        Map<Integer, Integer> statistics = getStatistics(allShuffledNumbers, winningNumbers);

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

    private static List<LottoResult> getLottoResults(Map<Integer, Integer> statistics) {
        List<LottoResult> lottoResults = new ArrayList<>();

        for (LottoPrize lottoPrize : LottoPrize.values()) {
            lottoResults.add(getLottoResult(statistics, lottoPrize.getCount(), lottoPrize.getPrizeMoney()));
        }
        return lottoResults;
    }

    private static LottoResult getLottoResult(Map<Integer, Integer> statistics, int count, long prizeMoney) {
        int winningCaseCount = statistics.getOrDefault(count, 0);

        return new LottoResult.Builder()
                .setStatistics(statistics)
                .setCount(count)
                .setWinningCaseCount(winningCaseCount)
                .setPrizeMoney(prizeMoney)
                .setWinAmount((long) prizeMoney * winningCaseCount)
                .build();
    }

    private static Map<Integer, Integer> getStatistics(List<List<Integer>> allShuffledNumbers, List<Integer> winningNumbers) {
        Map<Integer, Integer> statistics = new HashMap<>();

        for (List<Integer> shuffledNumber : allShuffledNumbers) {
            int sameNumberCount = getSameNumberCount(shuffledNumber, winningNumbers);
            int value = statistics.getOrDefault(sameNumberCount, 0);
            value++;
            statistics.put(sameNumberCount, value);
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
