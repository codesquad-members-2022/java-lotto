package view;

import domain.LottoSheet;
import domain.Rank;

import java.util.LinkedHashMap;
import java.util.List;

public class OutputView {

    private static final String PURCHASE_CONFIRMATION_MESSAGE = "개를 구매했습니다.";

    public static void printLotto(List<LottoSheet> lottoTicket, int numberOfLotto) {
        System.out.println(numberOfLotto + PURCHASE_CONFIRMATION_MESSAGE);

        lottoTicket.stream().map(LottoSheet::getLottoNumbers).forEach(System.out::println);
    }

    private static void printBonusNumberMessage(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            System.out.print(", 보너스 볼 일치");
        }
    }

    public static void printProfitTable(LinkedHashMap<Rank,Integer> winningResult) {
        System.out.println("당첨 통계");
        System.out.println("----------");

        for (Rank key : winningResult.keySet()) {
            System.out.print(key.getCountOfMatch() + "개 일치");
            printBonusNumberMessage(key);
            System.out.println(" (" + key.getWinningMoney() + "원) - " + winningResult.get(key) + "개");
        }
    }

    public static void printProfit(double profit) {
        System.out.println("총 수익률은 " + String.format("%.2f", profit) + "%입니다.");
    }
}
