package controller;

import domain.Ball;
import domain.Lotto;
import domain.User;
import view.InputView;
import view.OutputView;

public class Controller {

    public void play() {
        User user = InputView.askHowManyLottos();
        user.buy();
        OutputView.printLottos(user.getLottos());
        Lotto winningLotto = InputView.createWinningLotto();
        Ball bonusBall = InputView.getBonusBall();
        user.matchWinningLotto(winningLotto, bonusBall);
        OutputView.printResult(user);
        InputView.close();
    }
}
