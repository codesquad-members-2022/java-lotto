package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.stream.Stream;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int paidAmount = inputView.getPaidAmount();
        LottoBundle lottoBundle = LottoBundle.createByCashValue(paidAmount);

        int manualTicketCount = inputView.getManualTicketCount();
        addManualTickets(lottoBundle, manualTicketCount);

        lottoBundle.fillWithRandomLottoTickets();

        outputView.printPurchaseResult(lottoBundle);

        int[] winningNumberInput = inputView.getWinningNumber();
        int bonusNumberInput = inputView.getBonusNumber();
        WinningNumber winningNumber = LottoFactory.selectWinningNumber(winningNumberInput, bonusNumberInput);
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);

        outputView.printLottoResult(lottoResult);

        inputView.close();
    }

    private void addManualTickets(LottoBundle lottoBundle, int manualTicketCount) {
        int[][] numbers = inputView.getManualLottoNumbers(manualTicketCount);
        Stream.of(numbers).forEach(lottoBundle::addManualLottoTicket);
    }
}
