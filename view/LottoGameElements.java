package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.BonusNumber;
import PACKAGE_NAME.domain.LottoNumber;
import PACKAGE_NAME.domain.LottoTickets;

import java.util.Set;

public class LottoGameElements {
    private LottoTickets lottoTickets;
    private Set<LottoNumber> winningNumbers;
    private BonusNumber bonusNumber;

    public LottoGameElements(LottoTickets lottoTickets, Set<LottoNumber> winningNumbers, BonusNumber bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public Set<LottoNumber> getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
