import java.util.List;

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

    public static void showWinningStatistic(String result) {
        System.out.println(result);
    }

    private static void showLottoNumber(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < LOTTO_NUMBER_MAX_INDEX; i++) {
            System.out.printf("%d,", lotto.getNumber(i));
        }
        System.out.println(lotto.getNumber(LOTTO_NUMBER_MAX_INDEX) + "]");
    }
}
