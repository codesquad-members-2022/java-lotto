package controller;

import java.util.List;

import domain.Lotto;
import domain.LottoShop;
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
        int userMoney = inputView.getMoneyInput();
        List<Lotto> order = lottoShop.order(userMoney);
        outputView.printLotteries(order);
        List<Integer> answers = inputView.getAnswerInput();
    }
}
