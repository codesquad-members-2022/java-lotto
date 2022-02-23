package controller;

import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoShop;
import domain.Rank;
import domain.WinningNumbers;
import view.InputView;
import view.OutputView;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;
    private LottoShop lottoShop;

    public LottoController(InputView inputView, OutputView outputView, LottoShop lottoShop) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoShop = lottoShop;
    }

    public void runLotto() {
        //TODO : 메소드로 분리
        int userMoney = inputView.getMoneyInput();
        List<Lotto> purchasedLotteries = lottoShop.order(userMoney);
        outputView.printLotteries(purchasedLotteries);
        List<Integer> winningNumberInput = inputView.getWinningNumberInput();
        int bonusNumberInput = inputView.getBonusNumberInput(winningNumberInput);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberInput, bonusNumberInput);
        Map<Rank, Integer> result = lottoShop.getResult(purchasedLotteries, winningNumbers);
        outputView.printStatistics(result, userMoney);
    }
}
