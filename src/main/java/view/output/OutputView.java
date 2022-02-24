package view.output;

import domain.lotto.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class OutputView {
    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(lottoTickets);
        System.out.println();
    }

    public static void printLottoGameResults(LottoGameResults lottoGameResults) {
        System.out.println("당첨 통계");
        System.out.println("---------");
        System.out.println(makeRewardsString(lottoGameResults));
        System.out.printf("총 수익률은 %.2f %% 입니다", lottoGameResults.getReturnToInvestment());
    }

    private static String makeRewardsString(LottoGameResults lottoGameResults) {
        return Arrays.stream(Rank.values())
                    .filter(rank -> rank != Rank.FAILED)
                    .sorted(Comparator.comparing(Rank::getReward))
                    .map(rank -> String.format("%s - %d개", rank, lottoGameResults.getRankCountOf(rank)))
                    .collect(Collectors.joining("\n"));
    }

    public static void printLottoTicketCounts(LottoTickets manualLottoTickets, LottoTickets randomLottoTickets) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",
                manualLottoTickets.getCountOfLottoTickets(),
                randomLottoTickets.getCountOfLottoTickets());
    }
}
