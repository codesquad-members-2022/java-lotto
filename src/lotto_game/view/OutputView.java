package lotto_game.view;

import lotto_game.domain.Lotto;
import lotto_game.domain.LottoGames;
import lotto_game.MatchNumber;

import java.util.Map;

public class OutputView {

    public void printLottoGamesSize(LottoGames lottoGames) {
        System.out.println(lottoGames.getLottoList().size() + "개를 구매했습니다.");
    }

    public void printLottoGames(LottoGames lottoGames) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottoGames.getLottoList().size(); i++) {
            Lotto lotto = lottoGames.getLottoList().get(i);
            makeStringBuilder(sb, lotto);
        }
        System.out.println(sb);
    }

    private void makeStringBuilder(StringBuilder sb, Lotto lotto) {
        sb.append("[");
        for (int i = 0; i < lotto.getLottoNumberList().size(); i++) {
            sb.append(lotto.getLottoNumberList().get(i)).append(", ");
        }
        sb.delete(sb.length() - 2, sb.length() + 1).append("]").append('\n');
    }

    public void printProfitRate(int rate, Map<MatchNumber, Integer> resultMap) {
        System.out.println("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- " + resultMap.get(MatchNumber.THREE) + "개\n" +
                "4개 일치 (50000원)- " + resultMap.get(MatchNumber.FOUR) + "개\n" +
                "5개 일치 (1500000원)- " + resultMap.get(MatchNumber.FIVE) + "개\n" +
                "5개 일치, 보너스 볼 일치(30000000원) - " + resultMap.get(MatchNumber.FIVE_CONTAIN_BONUS) + "개\n" +
                "6개 일치 (2000000000원)- " + resultMap.get(MatchNumber.SIX) + "개");
        System.out.println("총 수익률은 " + rate + "%");
    }
}
