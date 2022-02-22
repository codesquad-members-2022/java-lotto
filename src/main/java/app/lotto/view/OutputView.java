package app.lotto.view;

import app.lotto.domain.LottoPrize;

import java.util.Collections;
import java.util.List;

public class OutputView {

    public static void printLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printAllSuffledNumbers(List<List<Integer>> allShuffledNumbers) {
        for (List<Integer> shuffledNumbers : allShuffledNumbers) {
            Collections.sort(shuffledNumbers);
            System.out.println(shuffledNumbers);
        }
    }

    public static void printWinStatistics(List<LottoResult> lottoResults) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (LottoResult lottoResult : lottoResults) {
            printLottoResult(lottoResult);
        }
    }

    private static void printLottoResult(LottoResult lottoResult) {
        if (lottoResult.getLottoPrize().equals(LottoPrize.SECOND)) {
            System.out.printf("%d개 일치, 보너스 볼 일치(%d원) - %d개\n", lottoResult.getLottoPrize().getCount(), lottoResult.getLottoPrize().getPrizeMoney(), lottoResult.getWinningCaseCount());
            return ;
        }
        System.out.printf("%d개 일치 (%d원) - %d개\n", lottoResult.getLottoPrize().getCount(), lottoResult.getLottoPrize().getPrizeMoney(), lottoResult.getWinningCaseCount());
    }

    public static void printTotalProfit(double totalProfit) {
        System.out.printf("총 수익률은 %.2f%%입니다.", totalProfit);
    }
}
