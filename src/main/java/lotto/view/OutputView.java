package lotto.view;

import java.util.List;

public class OutputView {

    private static final String PURCHASED_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_STATS = "당첨 통계";
    private static final String DIVISION_LINE = "---------";
    private static final String CORRECT_THREE_NUMBER = "3개 일치 (5000원)- %d개";
    private static final String CORRECT_FOUR_NUMBER = "4개 일치 (50000원)- %d개";
    private static final String CORRECT_FIVE_NUMBER = "5개 일치 (1500000원)- %d개";
    private static final String CORRECT_SIX_NUMBER = "6개 일치 (2000000000원)- %d개";
    private static final String TOTAL_PROFIT_MESSAGE = "총 수익률은 %2f%입니다.";

    public static void printPurchaseCount(int lottoSize) {
        System.out.println(lottoSize + PURCHASED_COUNT_MESSAGE);
    }

    public static void printLottoPaper(String lottoPaper) {
        System.out.println(lottoPaper);
    }

    public static void printWinningStats(List<Integer> eachRanks, double profit) {
        System.out.println(WINNING_STATS);
        System.out.println(DIVISION_LINE);
        System.out.printf(CORRECT_THREE_NUMBER + "\r\n", eachRanks.get(0));
        System.out.printf(CORRECT_FOUR_NUMBER + "\r\n", eachRanks.get(1));
        System.out.printf(CORRECT_FIVE_NUMBER + "\r\n", eachRanks.get(2));
        System.out.printf(CORRECT_SIX_NUMBER + "\r\n", eachRanks.get(3));
        System.out.printf(TOTAL_PROFIT_MESSAGE + "\r\n", profit);
    }
}
