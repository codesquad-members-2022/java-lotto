package domain;

import java.util.List;

public class LottoSheet {

    List<Integer> lottoNumbers;

    public LottoSheet(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
