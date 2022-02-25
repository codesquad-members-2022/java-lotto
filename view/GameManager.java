package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.*;

import java.util.Map;
import java.util.Set;

public class GameManager {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoController lottoController = new LottoController();

    public void play() {
        while (true) {
            Money money = new Money(inputView.inputMoney());
            LottoGameElements elements = getLottoGameElements(money);
            GameResult gameResult = lottoController.getLottoGameResult(elements);
            printResults(gameResult);
            askContinuously();
        }
    }

    private LottoGameElements getLottoGameElements(Money money) {
        LottoTickets lottoTickets = lottoController.getLottoTickets(money);
        printLottoTickets(lottoTickets);

        Set<LottoNumber> winningNumbers = inputView.inputWinningNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        return new LottoGameElements(lottoTickets, winningNumbers, bonusNumber);
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTicket(lottoTickets);
    }

    private void printResults(GameResult gameResult) {
        printLottoResult(gameResult.getMatchOfRank());
        printRateOfReturn(gameResult.getRateOfReturn());
    }

    private void printLottoResult(Map<Rank, Integer> numberMatch) {
        outputView.printLottoResult(numberMatch);
    }

    private void printRateOfReturn(RateOfReturn rateOfReturn) {
        outputView.printRateOfReturn(rateOfReturn);
    }

    private void askContinuously() {

    }
}
