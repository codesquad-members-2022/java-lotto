package nb993.view;

import java.util.List;
import java.util.Map;
import nb993.model.LottoTicket;
import nb993.model.Rank;

public class PrintView {

    public void printLottos(List<LottoTicket> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(Map<Rank, Integer> rankResult, int purchaseAmount) {
        System.out.println("당첨통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원) - " + rankResult.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50000원) - " + rankResult.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1500000원) - " + rankResult.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치(30000000원) - " + rankResult.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2000000000원) - " + rankResult.getOrDefault(Rank.FIRST, 0) + "개");

        double resultAmount = 5000 * rankResult.getOrDefault(Rank.FIFTH, 0) + 50000 * rankResult.getOrDefault(Rank.FOURTH, 0)
            + 1500000 * rankResult.getOrDefault(Rank.THIRD, 0) + 30000000 * rankResult.getOrDefault(Rank.SECOND, 0)
            + 2000000000 * rankResult.getOrDefault(Rank.FIRST, 0);
        System.out.println("총 수익률은 " + (resultAmount - purchaseAmount) / purchaseAmount * 100 + "%입니다");
    }
}
