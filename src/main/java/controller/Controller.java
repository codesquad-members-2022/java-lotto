package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class Controller {

    public void play() {
        User user = InputView.askHowManyLottos();
        InputView.sellLottos(user);
        OutputView.printLottos(user);
        WinningLotto winningLotto = InputView.createWinningLotto();
        user.matchWinningLotto(winningLotto);
        OutputView.printResult(user);
        InputView.close();
    }
}
