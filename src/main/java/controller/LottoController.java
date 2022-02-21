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
}
