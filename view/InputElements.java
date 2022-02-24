package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.BonusNumber;
import PACKAGE_NAME.domain.LottoTickets;

import java.util.Set;

public class InputElements {
    private LottoTickets lottoTickets;
    private Set<Integer> winningNumbers;
    private BonusNumber bonusNumber;

    public InputElements(LottoTickets lottoTickets, Set<Integer> winningNumbers, BonusNumber bonusNumber) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoTickets getLottoTickets() {
        return lottoTickets;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public BonusNumber getBonusNumber() {
        return bonusNumber;
    }
}
