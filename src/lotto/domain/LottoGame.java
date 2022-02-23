package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        int paidAmount = inputView.getPaidAmount();
        LottoBundle lottoBundle = new LottoBundle(paidAmount);
        lottoBundle.issueLottoTicketsWithRandomNumbers();

        outputView.printPurchaseResult(lottoBundle);

        int[] winningNumberInput = inputView.getWinningNumber();
        WinningNumber winningNumber = new WinningNumber(winningNumberInput, 1);
        LottoResult lottoResult = new LottoResult(lottoBundle, winningNumber);

        outputView.printLottoResult(lottoResult);

        inputView.close();
    }
}
