package domain.lotto;

import java.util.Set;

public class WinningTicket {

    private final Set<LottoNumber> winningNumbers;

    public WinningTicket(Set<LottoNumber> winningNumbers) {
        this.winningNumbers = winningNumbers;
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
