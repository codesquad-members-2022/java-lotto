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
            sb.append(rank.toString() + " - " + winingResult.get(rank) + "개\n");
        }

        System.out.println(sb);
    }

    public static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

}
