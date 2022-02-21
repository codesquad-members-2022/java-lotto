package lotto_game.view;

import lotto_game.Lotto;
import lotto_game.Lottos;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void printLottoSize(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            Lotto lotto = lottos.getLottos().get(i);
            makeStringBuilder(sb, lotto);
        }
        System.out.println(sb);
    }

    private void makeStringBuilder(StringBuilder sb, Lotto lotto) {
        sb.append("[");
        for (int j = 0; j < lotto.getLottoNumbers().size(); j++) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            sb.append(lottoNumbers.get(j)).append(", ");
        }
        sb.delete(sb.toString().length() - 2, sb.toString().length() + 1).append("]").append('\n');
    }

    public void printIncomeRate(String rate, Map<Integer, Integer> count) {
        System.out.println("당첨 통계\n" +
                "---------\n" +
                "3개 일치 (5000원)- "+count.get(3)+"개\n" +
                "4개 일치 (50000원)- "+count.get(4)+"개\n" +
                "5개 일치 (1500000원)- "+count.get(5)+"개\n" +
                "6개 일치 (2000000000원)- "+count.get(6)+"개");
        System.out.println("총 수익률은 " + rate + "%");
    }
}
