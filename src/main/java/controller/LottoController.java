package controller;

import domain.lotto.*;
import view.input.InputView;
import view.output.OutputView;

public class LottoController {

    public void run() {
        LottoTickets lottoTickets = buyLottoTickets();

        WinningTicket winningTicket = InputView.inputWinningTicket();
        LottoGameResults lottoGameResults = new LottoGameResults(lottoTickets, winningTicket);
        OutputView.printLottoGameResults(lottoGameResults);
        InputView.close();
    }


    private LottoTickets buyLottoTickets() {
        Money money = InputView.inputMoney();
        int count = InputView.inputCountOfManualLottoTicket(money);
        LottoTickets manualLottoTickets = LottoTickets.createManualTickets((InputView.inputManualLottoTickets(count)));
        LottoTickets randomLottoTickets = LottoTickets.createRandomTickets(money.numberOfBuyableLottoTickets() - count);
        LottoTickets allLottoTickets = LottoTickets.merge(manualLottoTickets, randomLottoTickets);

        OutputView.printLottoTicketCounts(manualLottoTickets, randomLottoTickets);
        OutputView.printLottoTickets(allLottoTickets);
        return allLottoTickets;
    }
}
