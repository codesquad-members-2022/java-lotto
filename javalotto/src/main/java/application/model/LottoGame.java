package application.model;

import java.util.ArrayList;
import java.util.List;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoGame {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void init(int userPurchaseAmount) {
        int numberOfManualLotto = InputView.getNumberOfManualLotto(userPurchaseAmount);
        int userPurchaseQuantity = userPurchaseAmount / LOTTO_TICKET_PRICE - numberOfManualLotto;

        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(LottoTicket.makeManualLotto(numberOfManualLotto));
        lottos.addAll(LottoTicket.makeAutoLotto(userPurchaseQuantity));

        OutputView.printPurchaseQuantity(numberOfManualLotto, userPurchaseQuantity);
        OutputView.printLottoList(lottos);
        start(lottos);
    }

    private void start(List<Lotto> lottos) {
        Lotto userWinningNumber = new Lotto(InputView.getWinningNumber());
        int bonusBallNumber = InputView.getBonusBall();
        int[] counts = Statistics.makeStatistics(lottos, userWinningNumber, bonusBallNumber);
        double totalYield = Statistics.calculateYield(counts);
        OutputView.printWinningStatistics(counts, totalYield);
    }

}
