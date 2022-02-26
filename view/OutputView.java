package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.domain.Rank;
import PACKAGE_NAME.domain.RateOfReturn;

import java.util.Map;

public class OutputView {

    private static final int DEFAULT_COUNT = 0;
    private static final String LINE = "----------";
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String BUYING_MESSAGE = "개를 구매했습니다.";
    private static final String TOTAL_RATE_OF_RETURN = "총 수익률은 ";
    private static final String PERCENT = "% 입니다.";

    public void printLottoResult(Map<Rank, Integer> matchOfRank) {
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE);
        printResults(matchOfRank);
    }

    private void printResults(Map<Rank, Integer> numberMatch){
        System.out.println(Rank.FOURTH.getDescription() + numberMatch.getOrDefault(Rank.FOURTH, DEFAULT_COUNT));
        System.out.println(Rank.THIRD.getDescription() + numberMatch.getOrDefault(Rank.THIRD, DEFAULT_COUNT));
        System.out.println(Rank.SECOND.getDescription() + numberMatch.getOrDefault(Rank.SECOND, DEFAULT_COUNT));
        System.out.println(Rank.BONUS.getDescription() + numberMatch.getOrDefault(Rank.BONUS, DEFAULT_COUNT));
        System.out.println(Rank.FIRST.getDescription() + numberMatch.getOrDefault(Rank.FIRST, DEFAULT_COUNT));
    }

    public void printLottoTicket(LottoTickets lottoTickets) {
        int ticketCount = lottoTickets.getLottoTickets().size();
        System.out.println(ticketCount + BUYING_MESSAGE);

        lottoTickets.getLottoTickets()
                .forEach(System.out::println);
    }

    public void printRateOfReturn(RateOfReturn rateOfReturn) {
        System.out.println(TOTAL_RATE_OF_RETURN + rateOfReturn + PERCENT);
    }
}
