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
        boolean check = true;
        while (check) {
            Lotto lotto = LottoMachine.createRandomLotto();
            check = user.buyLotto(lotto);
        }
        OutputView.printLottos(user.getLottos());
        Lotto winningLotto = InputView.createWinningLotto();
        Ball bonusBall = InputView.getBonusBall();
        user.matchWinningLotto(winningLotto, bonusBall);
        OutputView.printResult(user);
        InputView.close();
    }
}
