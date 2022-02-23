package controller;

import domain.Ball;
import domain.Lotto;
import domain.LottoMachine;
import domain.User;
import view.InputView;
import view.OutputView;

public class Controller {

    public void play() {
        User user = InputView.askHowManyLottos();
        LottoMachine.sellLotto(user);
        OutputView.printLottos(user.getLottos());
        Lotto winningLotto = InputView.createWinningLotto();
        Ball bonusBall = InputView.getBonusBall();
        user.matchWinningLotto(winningLotto, bonusBall);
        OutputView.printResult(user);
        InputView.close();
    }
}
