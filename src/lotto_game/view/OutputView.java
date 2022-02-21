package lotto_game.view;

import lotto_game.Lotto;
import lotto_game.Lottos;

import java.util.List;

public class OutputView {

    public void printLottoSize(Lottos lottos) {
        System.out.println(lottos.getLottos().size() + "개를 구매했습니다.");
    }

    public void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            Lotto lotto = lottos.getLottos().get(i);
            System.out.println("[" +
                    lotto.getFirstNumber() +
                    ", " + lotto.getSecondNumber() +
                    ", " + lotto.getThirdNumber() +
                    ", " + lotto.getFourthNumber() +
                    ", " + lotto.getFifthNumber() +
                    ", " + lotto.getSixthNumber() +
                    ']');
        }
    }
}
