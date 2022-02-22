package view;

import domain.Rank;

public class OutputView {

    public static void printBenefitPercentage(double method) {
        System.out.printf("총 수익률은 %5.2f%%입니다.", method);
    }

    public static void printStatisticalResult(int[] result) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        for (int index = 3; index < result.length; index++) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n", index, Rank.getWinningMoney(index), result[index]));
        }

        System.out.println(sb);
    }
}
