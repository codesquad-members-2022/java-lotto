package application.model;

import java.util.List;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoGame {

    public void init() {
        List<Lotto> lottos = LottoTicket.makeLotto();
        List<Integer> userWinningNumber = InputView.getWinningNumber();
        int bonusBallNumber = InputView.getBonusBall();
        start(lottos, userWinningNumber, bonusBallNumber);
    }

    private void start(List<Lotto> lottos, List<Integer> userWinningNumber, int bonusBallNumber) {
        int[] counts = Statistics.makeStatistics(lottos, userWinningNumber, bonusBallNumber);
        double totalYield = Statistics.calculateYield(counts);
        OutputView.printWinningStatistics(counts, totalYield);
    }
}
