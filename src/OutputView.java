import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int LOTTO_NUMBER_MAX_INDEX = 5;    // 로또번호 인덱스: [0 ~ 5]
    private static final int MATCH_START_NUMBER = 3;        // 당첨번호 일치하는 개수 첫번째
    private static final int MATCH_LAST_NUMBER = 6;         // 당첨번호 일치하는 개수 마지막
    private static final int[] PRIZE_MONEY = {0, 1000, 2500, 5000, 50000, 1500000, 2000000000};

    public static void showLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void showLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            showLottoNumber(lottoList.get(i));
        }
    }

    public static void showWinningStatistic(Map<Integer, Integer> statistic, int purchaseMoney) {
        int sum = 0;
        System.out.printf("당첨 통계%n---------%n");
        for (int i = MATCH_START_NUMBER; i <= MATCH_LAST_NUMBER; i++) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", i, PRIZE_MONEY[i], statistic.get(i));
            sum += PRIZE_MONEY[i] * statistic.get(i);
        }
        System.out.printf("총 수익률은 %.2f%%입니다.", (((float) sum - purchaseMoney) * 100 / purchaseMoney));
    }

    private static void showLottoNumber(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < LOTTO_NUMBER_MAX_INDEX; i++) {
            System.out.printf("%d,", lotto.getNumbers().get(i));
        }
        System.out.println(lotto.getNumbers().get(LOTTO_NUMBER_MAX_INDEX) + "]");
    }
}
