package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoTickets;

import java.util.Map;

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


    public void printLottoResult(Map<Integer, Integer> numberMatch) {
        System.out.println(WINNING_STATISTIC);
        System.out.println(LINE);

        for (int index = THREE; index <= SIX; index++) {
            if (index == THREE) {
                System.out.println(index + (COUNT + MATCH + FRONT_BRACKET + FOURTH__WINNING_MONEY + LAST_BRACKET + numberMatch.getOrDefault(index, DEFAULT_COUNT) + COUNT));
            }
            if (index == FOUR) {
                System.out.println(index + (COUNT + MATCH + FRONT_BRACKET + THIRD_WINNING_MONEY + LAST_BRACKET + numberMatch.getOrDefault(index, DEFAULT_COUNT) + COUNT));
            }
            if (index == FIVE) {
                System.out.println(index + (COUNT + MATCH + FRONT_BRACKET + SECOND_WINNING_MONEY + LAST_BRACKET + numberMatch.getOrDefault(index, DEFAULT_COUNT) + COUNT));
            }
            if (index == SIX) {
                System.out.println(index + (COUNT + MATCH + FRONT_BRACKET + FIRST_WINNING_MONEY + LAST_BRACKET + numberMatch.getOrDefault(index, DEFAULT_COUNT) + COUNT));
            }
        }
    }

    public void printLottoTicket(LottoTickets lottoTickets) {
        lottoTickets.getLottoTickets()
                .forEach(System.out::println);
    }
}
