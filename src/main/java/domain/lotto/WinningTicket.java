package domain.lotto;

import java.util.Set;

public class WinningTicket {

    private final Set<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningTicket(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        validateDuplicateLottoNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateLottoNumber(Set<LottoNumber> winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 번호 %d가 당첨번호와 중복됩니다.", bonusNumber.getNumber()));
        }
    }

    public Rank match(LottoTicket lottoTicket) {
        long matchCount = calculateMatchCount(lottoTicket);
        return Rank.of(matchCount);
    }

    private long calculateMatchCount(LottoTicket lottoTicket) {
        return lottoTicket.getLottoNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
