package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.BonusNumber;
import PACKAGE_NAME.domain.LottoCompany;
import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTickets;

import java.util.Map;
import java.util.Set;

public class LottoController {

    private final LottoStore lottoStore = new LottoStore();
    private final LottoCompany lottoCompany = new LottoCompany();

    public LottoTickets getLottoTickets(int money) {
        int ticketCount = money / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoStore.getLottoTickets(ticketCount));

        return lottoTickets;
    }

    public void registWinningNumbers(Set<Integer> winningNumbers, BonusNumber bonusNumber) {
        lottoCompany.registWinningNumbers(winningNumbers, bonusNumber);
    }

    public Map<Integer, Integer> getWinningTickets(LottoTickets lottoTickets) {
        return lottoCompany.numberMatch(lottoTickets);
    }
}
