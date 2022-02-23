package application.model;

import java.util.List;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoGame {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void init() {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / LOTTO_TICKET_PRICE;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
        List<Lotto> lottos = LottoTicket.makeLotto(userPurchaseQuantity);
        OutputView.printLottoList(lottos);
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
