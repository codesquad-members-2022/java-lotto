package lotto_game.view;

import lotto_game.domain.Lotto;
import lotto_game.domain.LottoTicket;
import lotto_game.domain.Rank;

import java.util.Map;

public class OutputView {

    public static void printCountOfLotto(LottoTicket lottoTicket, int countOfManualLotto) {
        System.out.println("수동으로 " + countOfManualLotto + "장, 자동으로 " + (lottoTicket.getLottosList().size() - countOfManualLotto) + "개를 구매했습니다.");
    }

    public static void printLottoNumbers(LottoTicket lottoTicket) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoTicket.getLottosList().size(); i++) {
            Lotto lotto = lottoTicket.getLottosList().get(i);
            makeStringBuilder(sb, lotto);
        }
        System.out.println(sb);
    }

    private static void makeStringBuilder(StringBuilder sb, Lotto lotto) {
        sb.append("[");
        for (int i = 0; i < lotto.getLottoNumbersList().size(); i++) {
            sb.append(lotto.getLottoNumbersList().get(i)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() + 1).append("]").append('\n');
    }

    public static void printProfitRate(int rate, Map<Rank, Integer> resultMap) {
        System.out.println("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + resultMap.get(Rank.FIFTH) + "개\n" +
                "4개 일치 (50000원)- " + resultMap.get(Rank.FOURTH) + "개\n" +
                "5개 일치 (1500000원)- " + resultMap.get(Rank.THIRD) + "개\n" +
                "5개 일치, 보너스 볼 일치(30000000원) - " + resultMap.get(Rank.SECOND) + "개\n" +
                "6개 일치 (2000000000원)- " + resultMap.get(Rank.FIRST) + "개");
        System.out.println("총 수익률은 " + rate + "%");
    }
}
