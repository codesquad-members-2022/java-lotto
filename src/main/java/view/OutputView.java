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

    public static void showWinningResult(Map<Rank, Integer> statistics, double profitRate) {
        StringBuilder sb = new StringBuilder();
        sb.append("\n당첨 통계\n").append("__________\n");
        for (Rank rank : Rank.values()) {
            sb.append(rank.getMatchedNumber()).append("개 일치");
            sb.append(checkBonusBall(rank));
            sb.append(" (").append(rank.getPrize()).append(")원 - ");
            sb.append(statistics.get(rank)).append("개\n");
        }
        System.out.println(sb.toString());
        System.out.printf("총 수익률은 %.2f%%입니다.", profitRate);
    }

    private static String checkBonusBall(Rank rank){
        if (rank == Rank.SECOND) {
            return ", 보너스 볼 일치";
        }
        return "";
    }
}
