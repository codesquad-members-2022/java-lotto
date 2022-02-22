package view;

import domain.LottoTicket;
import domain.ProfitAmount;

import java.util.List;
import java.util.Map;

public class OutputView {
    private final int SELECTED_NUMBER = 6;

    public static void completePurchase(int numberOfTickets, int change, List<LottoTicket> tickets) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        System.out.println("거스름돈은 " + change + "원 입니다.");

        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getTicketInfo().toString());
        }
    }

    public static void showWinningResult(Map<Integer, Integer> statistics) {
        System.out.println("당첨 통계");
        System.out.println("__________");
        int matchedNumber;
        int prize;
        double profitRate = 0;
        for (ProfitAmount pa : ProfitAmount.values()) {
            matchedNumber = pa.getMatchedNumber();
            prize = pa.getPrize();
            System.out.printf("%d개 일치 (%d원) - %d개\n", matchedNumber, prize, statistics.get(matchedNumber));
        }
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
