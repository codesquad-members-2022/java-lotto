package lotto_game;

import lotto_game.view.InputView;

public class LottoManager {
    public void createLottos() {
        InputView inputView = new InputView();
        int count = inputView.inputPrice() / 1000;
        Lottos lottos = new Lottos(count);
    }
}
