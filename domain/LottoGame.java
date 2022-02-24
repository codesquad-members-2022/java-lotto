package PACKAGE_NAME.domain;

import PACKAGE_NAME.view.GameResult;
import PACKAGE_NAME.view.InputElements;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoGame {

    private LottoStore lottoStore = new LottoStore();
    private LottoCompany lottoCompany = new LottoCompany();

    public GameResult getResult(InputElements elements){
        LottoTickets lottoTickets = elements.getLottoTickets();
        Set<Integer> winningNumbers = elements.getWinningNumbers();
        BonusNumber bonusNumber = elements.getBonusNumber();

        registWinningNumbersToCompany(winningNumbers, bonusNumber);

        Map<Rank, Integer> ranksResults = lottoCompany.getMatchOfRank(lottoTickets);
        RateOfReturn rateOfReturn = new RateOfReturn(ranksResults, lottoTickets);
        return new GameResult(ranksResults, rateOfReturn);
    }

    private void registWinningNumbersToCompany(Set<Integer> winningNumbers, BonusNumber bonusNumber) {
        lottoCompany.registWinningNumbers(winningNumbers, bonusNumber);
    }

    public List<LottoTicket> getLottoTickets(int money) {
        return lottoStore.getLottoTickets(money);
    }
}
