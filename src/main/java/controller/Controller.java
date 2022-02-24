package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {

    public void play() {
        User user = InputView.askHowManyLottos();
        InputView.printSellCustomLottoCount();
        buyCustomLotto(user);
        buyRandomLotto(user);
        OutputView.printLottos(user);
        WinningLotto winningLotto = InputView.createWinningLotto();
        user.matchWinningLotto(winningLotto);
        OutputView.printResult(user);
        InputView.close();
    }

    private void buyCustomLotto(User user) {
        for (int i = 0; i < user.getCountOfCustom(); i++) {
            Lotto lotto = InputView.createLotto();
            user.buyLotto(lotto);
        }
    }

    private void buyRandomLotto(User user) {
        for (int i = 0; i < user.getCountOfAuto(); i++) {
            user.buyLotto(LottoMachine.createRandomLotto());
        }
    }
}
