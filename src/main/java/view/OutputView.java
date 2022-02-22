package view;

import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.Rank;

public class OutputView {

    public void printLotteries(List<Lotto> lotteries) {
        System.out.println(lotteries.size() + "개를 구매했습니다.");
        for (Lotto lottery : lotteries) {
            System.out.println(lottery.getLottoNumbers());
        }
    }

    public void printStatistics(Map<Rank, Integer> result, int userMoney) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        int totalPrize = 0;
        for (int i = 0; i < Rank.noRank.ordinal(); i++) {
            Rank rank = Rank.values()[i];
            String bonus = rank == Rank.rank2 ? ", 보너스 볼 일치" : "";
            int prize = rank.getPrize();
            int count = result.get(rank);
            System.out.printf("%d개 일치%s (%d원)- %d개%n",
                rank.getMatch(),
                bonus,
                prize,
                count);
            totalPrize += prize * count;
        }

        System.out.printf("총 수익률은 %.2f%%입니다.", ((float)totalPrize - userMoney) / userMoney * 100);
    }
}
