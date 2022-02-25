package app.lotto;

import app.lotto.domain.*;
import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(LottoAutoMachine.getLottoCount(amount));

        LottoTicketManager lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
        printAllLottoTickets(lottoTicketManager);

        WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(InputView.readWinningNumbers(), InputView.readBonusNumber());
        System.out.println();

        LottoGameDto result = new LottoGameDto.Builder()
                .addAllLottoTickets(lottoTicketManager.getCustomLottoTickets())
                .addAllLottoTickets(lottoTicketManager.getAutoLottoTickets())
                .setWinningLottoNumbers(winningLottoNumbers)
                .build();

        LottoGame lottoGame = LottoGame.createWithLottoGameDtoAndAmount(result, amount);
        lottoGame.printLottoGameResult();
    }

    private static void printAllLottoTickets(LottoTicketManager lottoTicketManager) {
        OutputView.printLottoCount(lottoTicketManager.getCustomTicketCount(), lottoTicketManager.getAutoTicketCount());
        OutputView.printAllLottoNumbers(lottoTicketManager.getCustomLottoTickets());
        OutputView.printAllLottoNumbers(lottoTicketManager.getAutoLottoTickets());
        System.out.println();
    }
}
