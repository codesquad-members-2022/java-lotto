package view;

import domain.Lotto;
import domain.Rank;
import domain.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "개를 구입했습니다.";
    private static final String NUMBER_DELIMITER = ", ";
    private static final String RESULT_MESSAGE = "당첨 통계\n--------";
    private static final String DETAILED_RESULT_MESSAGE = "%d개 일치 (%d원) - %d개\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %.2f%%입니다.";


    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + PURCHASE_MESSAGE);
        for (Lotto lotto : lottos) {
            List<Integer> ballNumbers = lotto.getBallNumbers();
            String lottoString = getLottoString(ballNumbers);
            System.out.println(lottoString);
        }
    }

    private static String getLottoString(List<Integer> ballNumbers) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        List<String> stringBallNumbers = ballNumbers.stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        sb.append(String.join(NUMBER_DELIMITER, stringBallNumbers));
        sb.append("]");
        return sb.toString();
    }

    public static void printResult(User user) {
        System.out.println(RESULT_MESSAGE);
        List<Rank> ranks = Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.FAIL))
                .sorted(Comparator.comparingInt(Rank::getPrice))
                .collect(Collectors.toList());
        for (Rank rank : ranks) {
            int count = user.countRank(rank);
            System.out.printf(DETAILED_RESULT_MESSAGE, rank.getMatchCount(), rank.getPrice(), count);
        }
        System.out.printf(PROFIT_MESSAGE, user.calculateRateOfReturn());
    }


}
