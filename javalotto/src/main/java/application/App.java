package application;

import application.model.LottoGame;
import application.view.InputView;

public class App {
    public static void main(String[] args) {
        LottoGame game = new LottoGame();
        game.init(InputView.getPurchaseAmount(), InputView.getNumberOfManualLotto());
    }
}
