package domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoTicket {

    private static final int LIMIT_LOTTO_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoTicket createRandomTicket() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != LIMIT_LOTTO_NUMBERS) {
            lottoNumbers.add(LottoNumber.getLottoRandomLottoNumber());
        }

        return new LottoTicket(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
