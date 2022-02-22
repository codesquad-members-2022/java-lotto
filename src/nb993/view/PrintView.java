package nb993.view;

import java.util.List;
import nb993.model.LottoTicket;

public class PrintView {

    public void printLottos(List<LottoTicket> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (int i = 0; i < lottos.size(); i++) {
            System.out.println(lottos.get(i));
        }
    }

    public void printResult(int[] result, int purchaseAmount) {
        System.out.println("당첨통계");
        System.out.println("-----------");
        System.out.println("3개 일치 (5000원) - " + result[3] + "개");
        System.out.println("4개 일치 (50000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1500000원) - " + result[5] + "개");
        System.out.println("6개 일치 (2000000000원) - " + result[6] + "개");

        double resultAmount = 5000 * result[3] + 50000 * result[4] + 1500000 * result[5]
            + 2000000000 * result[6];
        System.out.println("총 수익률은" + (resultAmount - purchaseAmount) / purchaseAmount + "%입니다");
    }
}
