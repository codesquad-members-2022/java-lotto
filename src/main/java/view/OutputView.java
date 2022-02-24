package view;

import domain.PurchasedLotteries;
import domain.Rank;
import domain.Result;

public class OutputView {

    public void printPurchasedLotteries(PurchasedLotteries purchasedLotteries) {
        System.out.println(purchasedLotteries.count() + "개를 구매했습니다.");
        purchasedLotteries.get().forEach(System.out::println);
    }

    public void printStatistics(Result result, float profitRate) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        for (int i = 0; i < Rank.NO_RANK.ordinal(); i++) {
            Rank rank = Rank.values()[i];
            String bonus = rank == Rank.RANK2 ? ", 보너스 볼 일치" : "";
            int prize = rank.getPrize();
            int count = result.getCount(rank);
            System.out.printf("%d개 일치%s (%d원)- %d개%n",
                rank.getMatchedCount(),
                bonus,
                prize,
                count);
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }
}
