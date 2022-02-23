package view;

import domain.Rank;

public class OutputView {
    private static int[] results;

    public static void readResult(int[] input) {
        results = input;
    }

    private OutputView() {}

    public static void showResult() {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int resultIndex = 3; resultIndex < results.length - 2; resultIndex++) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", resultIndex, Rank.getRank(resultIndex).getPrize(), results[resultIndex]);
        }
        for (int resultIndex = 7; resultIndex >= 6; resultIndex--) {
            System.out.printf("%d개 일치", Rank.getRank(resultIndex).getWinningCount());
            if (resultIndex == 7) {
                System.out.print(", 보너스볼 일치");
            }
            System.out.printf(" (%d원) - %d개%n", Rank.getRank(resultIndex).getPrize(), results[resultIndex]);
        }
    }

    public static void showStatistics() {
        int count = 0;
        int prizeSum = 0;
        for (int resultIndex = 0; resultIndex < results.length; resultIndex++) {
            count += results[resultIndex];
            prizeSum += Rank.getRank(resultIndex).getPrize() * results[resultIndex];
        }
        double ratio = (double) (prizeSum - count * 1000) / (count * 1000) * 100;
        System.out.printf("총 수익률은 %.2f%%입니다.%n", ratio);
    }
}
