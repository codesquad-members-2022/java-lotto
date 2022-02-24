package application.model;

import java.util.ArrayList;
import java.util.List;

import application.domain.Lotto;
import application.view.InputView;
import application.view.OutputView;

public class LottoGame {
    private static final int LOTTO_TICKET_PRICE = 1000;

    public void init() {
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int numberOfManualLotto = InputView.getNumberOfManualLotto();
        int userPurchaseQuantity = userPurchaseAmount / LOTTO_TICKET_PRICE - numberOfManualLotto;
        List<Lotto> lottos = new ArrayList<>();
        OutputView.printPleaseEnterYourManualNumbers();
        InputView.removeNewLine();
        for (int i = 0; i < numberOfManualLotto; i++) {
            lottos.add(new Lotto(InputView.getManualLotto()));
        }
        lottos.addAll(LottoTicket.makeLotto(userPurchaseQuantity));
        OutputView.printPurchaseQuantity(numberOfManualLotto, userPurchaseQuantity);
        OutputView.printLottoList(lottos);

        Lotto userWinningNumber = new Lotto(InputView.getWinningNumber());
        int bonusBallNumber = InputView.getBonusBall();
        start(lottos, userWinningNumber, bonusBallNumber);
    }

    private void start(List<Lotto> lottos, Lotto userWinningNumber, int bonusBallNumber) {
        int[] counts = Statistics.makeStatistics(lottos, userWinningNumber, bonusBallNumber);
        double totalYield = Statistics.calculateYield(counts);
        OutputView.printWinningStatistics(counts, totalYield);
    }
}
