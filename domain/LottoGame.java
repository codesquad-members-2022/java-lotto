package PACKAGE_NAME.domain;

import PACKAGE_NAME.view.GameResult;
import PACKAGE_NAME.view.LottoGameElements;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {

    private LottoStore lottoStore = new LottoStore();
    private LottoCompany lottoCompany = new LottoCompany();

    public List<LottoTicket> getLottoTickets(Money money) {
        return lottoStore.getLottoTickets(money);
    }

    public GameResult getResult(LottoGameElements elements){
        LottoTickets lottoTickets = elements.getLottoTickets();
        Set<LottoNumber> winningNumbers = elements.getWinningNumbers();
        BonusNumber bonusNumber = elements.getBonusNumber();

        registWinningNumbersToCompany(winningNumbers, bonusNumber);

        Map<Rank, Integer> rankResults = lottoCompany.getMatchOfRank(lottoTickets);
        RateOfReturn rateOfReturn = new RateOfReturn(rankResults, lottoTickets);
        return new GameResult(rankResults, rateOfReturn);
    }

    private void registWinningNumbersToCompany(Set<LottoNumber> winningNumbers, BonusNumber bonusNumber) {
        lottoCompany.registWinningNumbers(winningNumbers, bonusNumber);
    }

}
