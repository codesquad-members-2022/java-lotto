package domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LottoTicket {

    private static final int LIMIT_LOTTO_NUMBERS = 6;

    private final Set<LottoNumber> lottoNumbers;

    private LottoTicket(Set<LottoNumber> lottoNumbers) {
        validateLottoNumbersSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void validateLottoNumbersSize(Set<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() == LIMIT_LOTTO_NUMBERS) {
            return;
        }
        throw new IllegalArgumentException(String.format("서로 다른 로또 번호가 %d개 존재하지 않습니다.", LIMIT_LOTTO_NUMBERS));
    }

    public static LottoTicket createRandomTicket() {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() != LIMIT_LOTTO_NUMBERS) {
            lottoNumbers.add(LottoNumber.getLottoRandomLottoNumber());
        }

        return new LottoTicket(lottoNumbers);
    }

    public static LottoTicket createManualTicket(Set<LottoNumber> lottoNumbers) {
        return new LottoTicket(lottoNumbers);
    }

    public Set<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableSet(lottoNumbers);
    }
}
