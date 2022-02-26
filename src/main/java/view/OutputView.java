package view;

import domain.Lotto;
import domain.Rank;
import domain.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d장을 구매했습니다.\n";
    private static final String NUMBER_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "당첨 통계\n--------";
    private static final String DETAILED_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f%%입니다.";
    private static final String BONUS_MATCH_RESULT_MESSAGE = "%d개 일치, 보너스볼 일치 (%d원) - %d개\n";


    public static void printLottos(User user) {
        System.out.printf(PURCHASE_MESSAGE, user.getCountOfCustom(), user.getCountOfAuto());
        List<Lotto> lottos = user.getLottos();
        for (Lotto lotto : lottos) {
            List<String> stringBalls = lotto.getStringBalls();
            String lottoString = getLottoString(stringBalls);
            System.out.println(lottoString);
        }
    }

    private static String getLottoString(List<String> stringBalls) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(String.join(NUMBER_DELIMITER, stringBalls));
        sb.append("]");
        return sb.toString();
    }

    public static void printResult(User user) {
        System.out.println(RESULT_MESSAGE);
        List<Rank> ranks = orderByAscRanks();
        for (Rank rank : ranks) {
            int count = user.countRank(rank);
            String resultMessage = getResultMessage(rank);
            System.out.printf(resultMessage, rank.getMatchCount(), rank.getPrice(), count);
        }
        System.out.printf(PROFIT_MESSAGE, user.calculateRateOfReturn());
    }

    private static List<Rank> orderByAscRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.FAIL))
                .sorted(Comparator.comparingInt(Rank::getPrice))
                .collect(Collectors.toList());
    }

    private static String getResultMessage(Rank rank) {
        if (rank == Rank.SECOND) {
            return BONUS_MATCH_RESULT_MESSAGE;
        }
        return DETAILED_RESULT_MESSAGE;
    }


}
