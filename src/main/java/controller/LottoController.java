package controller;

import domain.lotto.*;
import view.input.InputView;
import view.output.OutputView;

public class LottoController {

    public void run() {
        LottoTickets lottoTickets = buyLottoTickets();
        WinningTicket winningTicket = prepareWinningTicket();
        matchLottoTicketsWithWinningTicket(lottoTickets, winningTicket);
        closeController();
    }

    private LottoTickets buyLottoTickets() {
        try {
            Money money = InputView.inputMoney();
            long countOfManualLottoTicket = InputView.inputCountOfManualLottoTicket(money);
            long countOfRandomlLottoTicket = money.numberOfBuyableLottoTickets() - countOfManualLottoTicket;
            LottoTickets manualLottoTickets = LottoTickets.createManualTickets((InputView.inputManualLottoTickets(countOfManualLottoTicket)));
            LottoTickets randomLottoTickets = LottoTickets.createRandomTickets(countOfRandomlLottoTicket);
            LottoTickets allLottoTickets = LottoTickets.merge(manualLottoTickets, randomLottoTickets);

            OutputView.printLottoTicketCounts(countOfManualLottoTicket, countOfRandomlLottoTicket);
            OutputView.printLottoTickets(allLottoTickets);
            return allLottoTickets;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return buyLottoTickets();
    }

    private WinningTicket prepareWinningTicket() {
        try {
            return InputView.inputWinningTicket();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println();
        }
        return prepareWinningTicket();
    }

    private void matchLottoTicketsWithWinningTicket(LottoTickets lottoTickets, WinningTicket winningTicket) {
        LottoGameResults lottoGameResults = new LottoGameResults(lottoTickets, winningTicket);
        OutputView.printLottoGameResults(lottoGameResults);
    }

    private void closeController() {
        InputView.close();
    }
}
