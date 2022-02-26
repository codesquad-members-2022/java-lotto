package domain.lotto;

import java.util.Set;

public class WinningTicket {

    private final LottoTicket winningLottoTicket;
    private final LottoNumber bonusNumber;

    public WinningTicket(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        validateDuplicateLottoNumber(winningLottoTicket, bonusNumber);
        this.winningLottoTicket = winningLottoTicket;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicateLottoNumber(LottoTicket winningLottoTicket, LottoNumber bonusNumber) {
        if (winningLottoTicket.contains(bonusNumber)) {
            throw new IllegalArgumentException(String.format("보너스 번호 %d가 당첨번호와 중복됩니다.", bonusNumber.getNumber()));
        }
    }

    public Rank match(LottoTicket lottoTicket) {
        int matchCount = calculateMatchCount(lottoTicket);
        boolean matchBonus = isMatchBonus(lottoTicket);
        return Rank.of(matchCount, matchBonus);
    }

    private boolean isMatchBonus(LottoTicket lottoTicket) {
        Set<LottoNumber> lottoNumbers = lottoTicket.getLottoNumbers();
        return lottoNumbers.contains(bonusNumber);
    }

    private int calculateMatchCount(LottoTicket lottoTicket) {
        return (int) lottoTicket.getLottoNumbers().stream()
                .filter(winningLottoTicket::contains)
                .count();
    }
}
