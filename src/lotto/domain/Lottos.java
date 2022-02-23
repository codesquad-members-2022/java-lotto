package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos = new ArrayList<>();

    public List<Lotto> buyLotto(int numOfLotto) {
        for (int i = 0; i < numOfLotto; i++) {
            lottos.add(Lotto.create());
        }
        return lottos;
    }

    public List<Lotto> buyLotto(List<Integer> lottoNumbers) {
        lottos.add(Lotto.create(lottoNumbers));
        return lottos;
    }
}
