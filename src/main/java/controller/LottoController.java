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
            int count = InputView.inputCountOfManualLottoTicket(money);
            LottoTickets manualLottoTickets = LottoTickets.createManualTickets((InputView.inputManualLottoTickets(count)));
            LottoTickets randomLottoTickets = LottoTickets.createRandomTickets(money.numberOfBuyableLottoTickets() - count);
            LottoTickets allLottoTickets = LottoTickets.merge(manualLottoTickets, randomLottoTickets);

            OutputView.printLottoTicketCounts(manualLottoTickets, randomLottoTickets);
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
