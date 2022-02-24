package controller;

import java.util.ArrayList;
import java.util.List;

import domain.Lotto.Lotto;
import domain.LottoGenerator;
import domain.PurchasedLotteries;
import domain.Result;
import domain.WinningNumbers;
import view.InputView;
import view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void runLotto() {
        PurchasedLotteries purchasedLotteries = purchase();
        outputView.printPurchasedLotteries(purchasedLotteries);

        WinningNumbers winningNumbers =  draw();

        Result result = purchasedLotteries.getResult(winningNumbers);
        outputView.printStatistics(result, purchasedLotteries.getProfitRate(winningNumbers));
    }

    private PurchasedLotteries purchase() {
        int userMoney = inputView.getMoneyInput();
        int manualLottoCount = inputView.getManualLottoCountInput(userMoney);
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = userMoney / Lotto.PRICE;
        List<List<Integer>> manualNumbersList = inputView.getManualNumbersInput(manualLottoCount);
        for (List<Integer> manualNumbers : manualNumbersList) {
            lotteries.add(LottoGenerator.generateManualLotto(manualNumbers));
        }
        for (int i = 0; i < lottoCount - manualLottoCount; i++) {
            lotteries.add(LottoGenerator.generateRandomLotto());
        }
        return new PurchasedLotteries(lotteries);
    }

    private WinningNumbers draw() {
        List<Integer> winningNumberInput = inputView.getWinningNumbersInput();
        int bonusNumberInput = inputView.getBonusNumberInput(winningNumberInput);
        return new WinningNumbers(winningNumberInput, bonusNumberInput);
    }
}
