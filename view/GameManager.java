package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoTickets;

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
            LottoTickets lottoTickets = lottoController.get(money);
            printLottoTickets(lottoTickets);

            Set<Integer> winningNumbers = inputView.inputWinningNumber();

            registWinningNumbersToCompany(winningNumbers);

            Map<Integer, Integer> numberMatch = lottoController.getWinningTickets(lottoTickets);

            printLottoResult(numberMatch);
            printRateOfReturn(money, lottoTickets, numberMatch);
        }
    }

    private void printLottoTickets(LottoTickets lottoTickets) {
        outputView.printLottoTicket(lottoTickets);
    }

    private void registWinningNumbersToCompany(Set<Integer> winningNumbers) {
        lottoController.registWinningNumbers(winningNumbers);
    }

    private void printLottoResult(Map<Integer, Integer> numberMatch) {
        outputView.printLottoResult(numberMatch);
    }

    private void printRateOfReturn(int money, LottoTickets lottoTickets, Map<Integer, Integer> numberMatch) {
        int sum = lottoTickets.winningAmount(numberMatch);
        double rateOfReturn = lottoTickets.calculateYield(sum, money);
        outputView.printRateOfReturn(sum, rateOfReturn);
    }
}
