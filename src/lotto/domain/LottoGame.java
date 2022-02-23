package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int paidAmount = inputView.getPaidAmount();
        LottoBundle lottoBundle = new LottoBundle(paidAmount);
        lottoBundle.fillWithRandomLottoTickets();

        outputView.printPurchaseResult(lottoBundle);

        int[] winningNumberInput = inputView.getWinningNumber();
        int bonusNumberInput = inputView.getBonusNumber();
        WinningNumber winningNumber = LottoFactory.selectWinningNumber(winningNumberInput, bonusNumberInput);
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);

        outputView.printLottoResult(lottoResult);

        inputView.close();
    }
}
