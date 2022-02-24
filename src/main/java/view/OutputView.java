package view;

import domain.Lotto;
import domain.Rank;

import java.util.*;

public class OutputView {

    public static void printBenefitPercentage(double percent) {
        System.out.printf("총 수익률은 %5.2f%%입니다.", percent);
    }

    public static void printStatisticalResult(Map<Rank, Integer> winingResult) {
        StringBuilder sb = new StringBuilder();
        sb.append("당첨 통계\n");
        sb.append("---------\n");
        Set<Rank> ranks = winingResult.keySet();

        for (Rank rank : ranks) {
            sb.append(String.format("%d개 일치 (%d원)- %d개\n", rank.getMatchCount(), rank.getWinningMoney(), winingResult.get(rank)));
        }

        System.out.println(sb);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
