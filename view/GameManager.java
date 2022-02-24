package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.BonusNumber;
import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.domain.Rank;

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
            LottoTickets lottoTickets = lottoController.getLottoTickets(money);
            printLottoTickets(lottoTickets);

            Set<Integer> winningNumbers = inputView.inputWinningNumber();
            BonusNumber bonusNumber = new BonusNumber(inputView.inputBonusNumber());
            registWinningNumbersToCompany(winningNumbers, bonusNumber);

            Map<Rank, Integer> numberMatch = lottoController.getWinningTickets(lottoTickets);

            printLottoResult(numberMatch);
            printRateOfReturn(money, lottoTickets, numberMatch);
        }
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTicket(lottoTickets);
    }

    private void registWinningNumbersToCompany(Set<Integer> winningNumbers, BonusNumber bonusNumber) {
        lottoController.registWinningNumbers(winningNumbers, bonusNumber);
    }

    private void printLottoResult(Map<Rank, Integer> numberMatch) {
        outputView.printLottoResult(numberMatch);
    }

    private void printRateOfReturn(int money, LottoTickets lottoTickets, Map<Rank, Integer> numberMatch) {
        int sum = lottoTickets.getWinningPrize(numberMatch);
        double rateOfReturn = lottoTickets.calculateRateOfReturn(sum, money);
        outputView.printRateOfReturn(sum, rateOfReturn);
    }
}
