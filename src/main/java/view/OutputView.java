package view;

import domain.Rank;

public class OutputView {
    private static int[] results;

    public static void readResult(int[] input) {
        results = input;
    }

    public static void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int winningCount = 3; winningCount < results.length; winningCount++) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", winningCount, Rank.getRank(winningCount).getPrize(), results[winningCount]);
        }
    }

    public static void showStatistics() {
        int count = 0;
        int prizeSum = 0;
        for (int winningCount = 0; winningCount < results.length; winningCount++) {
            count += results[winningCount];
            prizeSum += Rank.getRank(winningCount).getPrize() * results[winningCount];
        }
        double ratio = (double) (prizeSum - count * 1000) / (count * 1000) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.%n", ratio);
    }
}
