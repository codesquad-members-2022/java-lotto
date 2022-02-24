package domain.lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LIMIT_LOTTO_NUMBERS = 6;
    public static final int LOTTO_TICKET_PRICE = 1000;

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

    /**
     * 로또 티켓의 문자열 표현을 반환한다.
     * 각 번호는 중복되지 않은 로또 번호이다.
     * @return [x, x, x, x, x, x] 형태
     */
    @Override
    public String toString() {
        return lottoNumbers.stream().mapToInt(LottoNumber::getNumber)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
