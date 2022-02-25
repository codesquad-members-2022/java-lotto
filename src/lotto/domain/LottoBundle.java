package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {

    private List<Lotto> lottoBundle = new ArrayList<>();

    public List<Lotto> buyLotto(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            lottoBundle.add(Lotto.create());
        }
        return lottoBundle;
    }

    public List<Lotto> buyLotto(List<Integer> lottoNumbers) {
        lottoBundle.add(Lotto.create(lottoNumbers));
        return lottoBundle;
    }
}
