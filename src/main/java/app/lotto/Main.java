package app.lotto;

import app.lotto.view.InputView;

public class Main {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        int amount = inputView.readAmount();
    }
}
