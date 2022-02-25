package lotto.view;

import lotto.domain.WinningStrategy;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String DIVISION_LINE = "---------";
    private static final String CORRECT_THREE_NUMBER = "3개 일치 (5000원) - %d개";
    private static final String CORRECT_FOUR_NUMBER = "4개 일치 (50000원) - %d개";
    private static final String CORRECT_FIVE_NUMBER = "5개 일치 (1500000원) - %d개";
    private static final String CORRECT_BONUS_NUMBER = "5개 일치, 보너스 볼 일치 (30000000원) - %d개";
    private static final String CORRECT_SIX_NUMBER = "6개 일치 (2000000000원) - %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %.2f%%입니다.";

    public static void printPurchaseCount(int manualLottoCount, int autoLottoCount) {
        System.out.printf(PURCHASED_COUNT_MESSAGE + System.lineSeparator(),manualLottoCount, autoLottoCount);
    }

    public static void printLottoPaper(String lottoPaper) {
        System.out.println(lottoPaper);
    }

    public static void printWinningStats(List<WinningStrategy> winningStrategies, double profit) {
        System.out.println(WINNING_STATS);
        System.out.println(DIVISION_LINE);
        System.out.printf(CORRECT_THREE_NUMBER + System.lineSeparator(), getRank(winningStrategies, WinningStrategy.THREE_MATCHES));
        System.out.printf(CORRECT_FOUR_NUMBER + System.lineSeparator(), getRank(winningStrategies, WinningStrategy.FOUR_MATCHES));
        System.out.printf(CORRECT_FIVE_NUMBER + System.lineSeparator(), getRank(winningStrategies, WinningStrategy.FIVE_MATCHES));
        System.out.printf(CORRECT_BONUS_NUMBER + System.lineSeparator(), getRank(winningStrategies, WinningStrategy.FIVE_WITH_BONUS_MATCHES));
        System.out.printf(CORRECT_SIX_NUMBER + System.lineSeparator(), getRank(winningStrategies, WinningStrategy.SIX_MATCHES));
        System.out.printf(TOTAL_PROFIT_MESSAGE + System.lineSeparator(), profit);
    }

    private static int getRank(List<WinningStrategy> winningStrategies, WinningStrategy rank) {
        return (int) winningStrategies.stream()
                .filter(value -> value.equals(rank))
                .count();
    }
}
