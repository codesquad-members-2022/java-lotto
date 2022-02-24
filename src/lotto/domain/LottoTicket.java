package lotto.domain;

import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    private final LottoNumbers lottoNumbers;

    public LottoTicket(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
