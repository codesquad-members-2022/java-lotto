package controller;

import view.InputView;

public class LottoController {

    private InputView inputView;

    public LottoController(InputView inputView) {
        this.inputView = inputView;
    }

    public void runLotto() {
        int count = inputView.getInput();
    }

    private List<Lotto> order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return lotteries;
    }
}
