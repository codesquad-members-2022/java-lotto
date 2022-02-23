package view;

import domain.LottoTicket;
import domain.Rank;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void completePurchase(int numberOfTickets, int change, List<LottoTicket> tickets) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        System.out.println("거스름돈은 " + change + "원 입니다.");

        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getTicketInfo().toString());
        }
    }

    public static void showWinningResult(Map<Integer, Integer> statistics, double profitRate) {
        System.out.println("\n당첨 통계");
        System.out.println("__________");
        int matchedNumber;
        int prize;
        for (Rank pa : Rank.values()) {
            matchedNumber = pa.getMatchedNumber();
            prize = pa.getPrize();
            System.out.printf("%d개 일치 (%d원) - %d개", matchedNumber, prize, statistics.get(matchedNumber));
            System.out.println();
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }
}
