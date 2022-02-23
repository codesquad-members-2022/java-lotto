package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.Lotto;
import domain.LottoMaker;
import domain.MyLotteries;
import domain.Rank;
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
        //TODO : 메소드로 분리
        int userMoney = inputView.getMoneyInput();

        MyLotteries myLotteries = order(userMoney);
        outputView.printMyLotteries(myLotteries);
        List<Integer> winningNumberInput = inputView.getWinningNumberInput();
        int bonusNumberInput = inputView.getBonusNumberInput(winningNumberInput);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberInput, bonusNumberInput);
        Map<Rank, Integer> result = myLotteries.getResult(winningNumbers);
        outputView.printStatistics(result, userMoney);
    }

    private MyLotteries order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return new MyLotteries(lotteries);
    }
}
