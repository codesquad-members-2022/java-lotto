package view;

import domain.LottoSheet;
import domain.LottoTicket;
import domain.Rank;
import java.util.List;
import java.util.Map;

public class OutputView {

    public void printPurchaseConfirmMessage(int lottoQuantity, int manualLottoQuantity) {
        System.out.println("수동으로 " + manualLottoQuantity +"장, 자동으로 " + (lottoQuantity - manualLottoQuantity) + "장 구매했습니다.");
    }

    public void printLotto(LottoTicket lottoTicket) {
        List<LottoSheet> lottoSheetList = lottoTicket.getLottoTicket();
        lottoSheetList.stream().map(LottoSheet::getLottoNumbers).forEach(System.out::println);
    }

    private void printBonusNumberMessage(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            System.out.print(", 보너스 볼 일치");
        }
    }

    public void printProfitTable(Map<Rank, Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (Rank key : winningResult.keySet()) {
            System.out.print(key.getCountOfMatch() + "개 일치");
            printBonusNumberMessage(key);
            System.out.println(" (" + key.getWinningMoney() + "원) - " + winningResult.get(key) + "개");
        }
    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }
}
