import java.util.List;

public class OutputView {

    private static final int LOTTO_NUMBER_MAX_INDEX = 5;    // 6개 로또 번호별 인덱스: [0 ~ 5]

    public static void showLottoCount(int lottoCount) {
        System.out.printf("%d개를 구매했습니다.%n", lottoCount);
    }

    public static void showLottoList(List<Lotto> lottoList) {
        for (int i = 0; i < lottoList.size(); i++) {
            showLottoNumber(lottoList.get(i));
        }
    }

    private static void showLottoNumber(Lotto lotto) {
        System.out.print("[");
        for (int i = 0; i < LOTTO_NUMBER_MAX_INDEX; i++) {
            System.out.printf("%d,", lotto.getNumbers().get(i));
        }
        System.out.println(lotto.getNumbers().get(LOTTO_NUMBER_MAX_INDEX) + "]");
    }
}
