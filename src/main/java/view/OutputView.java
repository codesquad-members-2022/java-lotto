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
        StringBuilder sb = new StringBuilder();
        int matchedNumber;
        int prize;
        sb.append("\n당첨 통계\n");
        sb.append("__________\n");
        for (Rank rank : Rank.values()) {
            matchedNumber = rank.getMatchedNumber();
            prize = rank.getPrize();
            if (rank == Rank.SECOND){
                matchedNumber -= 2;
            }
            sb.append(matchedNumber).append("개 일치");

            if (rank == Rank.SECOND){
                matchedNumber += 2;
                sb.append(", 보너스 볼 일치");
            }
            sb.append(" (").append(prize).append(")원 - ");
            sb.append(statistics.get(matchedNumber)).append("개\n");
        }
        System.out.println(sb.toString());
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }
}
