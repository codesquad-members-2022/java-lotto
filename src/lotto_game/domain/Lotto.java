package lotto_game.domain;

import java.util.List;

public class Lotto {
    private List<Integer> lottoNumbers;

    public Lotto(List<Integer> numberList) {
        this.lottoNumbers = numberList;
    }

    public List<Integer> getLottoNumbersList() {
        return this.lottoNumbers;
    }
}
