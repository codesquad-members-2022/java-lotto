package application;

import java.util.List;

public class LottoGenerator {

    private List<Lotto> userLottos;
    private Lotto winLotto;

    private Statistics stat;

    public Lotto create() {
        return Lotto.generate();
    }
}
