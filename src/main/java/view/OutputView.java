package view;

import domain.LottoSheet;
import domain.LottoTicket;
import domain.ProfitCalculator;
import java.util.HashMap;
import java.util.List;

public class OutputView {

    private static final String PURCHASE_CONFIRMATION_MESSAGE = "개를 구매했습니다.";

    public void printLotto(LottoTicket lottoTicket, int numberOfLotto) {
        System.out.println(numberOfLotto + PURCHASE_CONFIRMATION_MESSAGE);

        List<LottoSheet> lottoSheets = lottoTicket.getLottoSheets();
        lottoSheets.stream().map(LottoSheet::getLottoNumbers).forEach(System.out::println);
    }

    public void printProfitTable(int[] winningResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");
        HashMap<Integer, Integer> winningPriceTable = ProfitCalculator.winningPriceTable;

        for (int key : winningPriceTable.keySet()) {
            System.out.println(
                key + "개 일치 (" + winningPriceTable.get(key) + "원) - " + winningResult[key] + "개");
        }
    }

    public void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }
}
