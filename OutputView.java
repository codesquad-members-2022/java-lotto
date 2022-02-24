import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int LOTTO_NUMBER_MAX_INDEX = 5;    // 6개 로또 번호별 인덱스: [0 ~ 5]

    public static void showCountOfLotto(int countOfManualLotto, int countOfAutoLotto) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", countOfManualLotto, countOfAutoLotto);
    }

    public static void showLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            showLottoNumber(lottoList.get(i));
        }
    }

    public static void showWinningStatistic(Map<RankValue, Integer> statistic, int purchaseMoney) {
        int sum = 0;
        System.out.printf("당첨 통계%n---------%n");
        for (RankValue rankValue : statistic.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개%n", rankValue.getCountOfMatch(), rankValue.getWinningMoney(), statistic.get(rankValue));
            sum += rankValue.getWinningMoney() * statistic.get(rankValue);
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
