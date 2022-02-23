package nb993.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import nb993.model.LottoTicket;
import nb993.model.Rank;

public class PrintView {

    public void printLottos(List<LottoTicket> lottos, int purchaseCount, int manualPurchaseCount) {
        System.out.println("수동으로 " + manualPurchaseCount + "장, 자동으로 "
            + (purchaseCount - manualPurchaseCount) + "개를 구매했습니다.");

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(Map<Rank, Integer> rankResult, int purchaseAmount, long resultAmount) {
        System.out.println("\n당첨통계");
        System.out.println("-----------");

        List<Rank> ranks = Arrays.stream(Rank.values())
            .filter(r -> r != Rank.NOTHING)
            .collect(Collectors.toList());

        for (Rank rank : ranks) {
            System.out.println(rank + "-" + rankResult.getOrDefault(rank, 0) + "개");
        }

        System.out.println("총 수익률은 " + (resultAmount - purchaseAmount) / purchaseAmount * 100 + "%입니다");
    }
}
