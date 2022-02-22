package view.output;

import domain.lotto.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        List<LottoTicket> tickets = lottoTickets.getLottoTickets();
        System.out.printf("%d개를 구매했습니다.\n", tickets.size());
        System.out.println(makeLottoTicketsString(tickets));
        System.out.println();
    }

    private static String makeLottoTicketsString(List<LottoTicket> tickets) {
        return tickets.stream()
                .map(OutputView::makeLottoTicketString)
                .collect(Collectors.joining("\n"));
    }

    private static String makeLottoTicketString(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .mapToInt(LottoNumber::getNumber)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    public static void printReward(RewardMachine rewardMachine) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(makeRewardsString(rewardMachine));
        System.out.printf("총 수익률은 %.2f %% 입니다", rewardMachine.getReturnToInvestment());
    }

    private static String makeRewardsString(RewardMachine rewardMachine) {
        return rewardMachine.getRankCounts().entrySet().stream()
                .filter(entry -> entry.getKey() != Rank.FAILED)
                .sorted(Comparator.comparing(entry -> entry.getKey().getCountOfMatch()))
                .map(entry ->
                        String.format("%d개 일치 (%d원) - %d개",
                                entry.getKey().getCountOfMatch(),
                                entry.getKey().getReward(),
                                entry.getValue()))
                .collect(Collectors.joining("\n"));
    }
}
