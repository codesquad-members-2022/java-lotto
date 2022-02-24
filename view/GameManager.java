package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.BonusNumber;
import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.domain.Rank;
import PACKAGE_NAME.domain.RateOfReturn;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameManager {

    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private LottoController lottoController = new LottoController();

    private static final List<Integer> lottoNumbers = IntStream.rangeClosed(1, 45)
            .boxed()
            .collect(Collectors.toList());

    public void play() {
        while (true) {
            int money = inputView.inputMoney();
            InputElements elements = getLottoGameElements(money);
            GameResult gameResult = lottoController.getLottoGameResult(elements);
            printResults(gameResult);
        }
    }

    private InputElements getLottoGameElements(int money) {
        LottoTickets lottoTickets = lottoController.getLottoTickets(money);
        printLottoTickets(lottoTickets);

        Set<Integer> winningNumbers = inputView.inputWinningNumber();
        BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
        return new InputElements(lottoTickets, winningNumbers, bonusNumber);
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
}
