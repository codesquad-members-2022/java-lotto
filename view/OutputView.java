package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.domain.Rank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {

    private static final int DEFAULT_COUNT = 0;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private static final String COUNT = "개";
    private static final String MATCH = " 일치 ";
    private static final int FOURTH__WINNING_MONEY = 5000;
    private static final int THIRD_WINNING_MONEY = 50000;
    private static final int SECOND_WINNING_MONEY = 1500000;
    private static final int FIRST_WINNING_MONEY = 2000000000;

    private static final String FRONT_BRACKET = "(";
    private static final String LAST_BRACKET = ")";
    private static final String LINE = "----------";
    private static final String WINNING_STATISTIC = "당첨 통계";
    private static final String TOTAL_WINNING_MONEY = "당첨금액 총합: ";
    private static final String BUYING_MESSAGE = "개를 구매했습니다.";
    private static Map<Integer, Integer> counts = new HashMap<>();

    static {
        counts.put(3, 3);
        counts.put(4, 4);
        counts.put(5, 5);
        counts.put(6, 6);
    }


    public void printLottoResult(Map<Rank, Integer> numberMatch) {
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE);
        System.out.println(Rank.FOURTH.getDescription()+numberMatch.getOrDefault(Rank.FOURTH, DEFAULT_COUNT));
        System.out.println(Rank.THIRD.getDescription()+numberMatch.getOrDefault(Rank.THIRD, DEFAULT_COUNT));
        System.out.println(Rank.SECOND.getDescription()+numberMatch.getOrDefault(Rank.SECOND, DEFAULT_COUNT));
        System.out.println(Rank.BONUS.getDescription()+numberMatch.getOrDefault(Rank.BONUS, DEFAULT_COUNT));
        System.out.println(Rank.FIRST.getDescription()+numberMatch.getOrDefault(Rank.FIRST, DEFAULT_COUNT));
    }

    public void printLottoTicket(LottoTickets lottoTickets) {
        int ticketCount = lottoTickets.getLottoTickets().size();
        System.out.println(ticketCount + BUYING_MESSAGE);

        lottoTickets.getLottoTickets()
                .forEach(System.out::println);
    }

    public void printRateOfReturn(int sum, double rateOfReturn) {
        System.out.println(TOTAL_WINNING_MONEY + sum);
        System.out.print("총 수익률은 " + rateOfReturn + "% 입니다.");
    }
}
