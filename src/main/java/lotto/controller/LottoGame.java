package lotto.controller;

import lotto.view.InputView;

public class LottoGame {

    public void start() {
        InputView.init();
        int purchaseAmount = InputView.getPurchaseAmount();
        InputView.close();
    }
}
