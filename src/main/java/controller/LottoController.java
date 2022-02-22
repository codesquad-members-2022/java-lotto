package controller;

import domain.lotto.LottoTickets;
import domain.lotto.Money;
import domain.lotto.LottoGameResults;
import domain.lotto.WinningTicket;
import view.input.InputView;
import view.output.OutputView;

public class LottoController {

    public void run() {
        Money money = InputView.inputMoney();
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(money);
        OutputView.printLottoTickets(lottoTickets);

        WinningTicket winningTicket = InputView.inputWinnigTicket();
        LottoGameResults lottoGameResults = new LottoGameResults(money, lottoTickets, winningTicket);

        OutputView.printLottoGameResults(lottoGameResults);
        InputView.close();
    }

}
