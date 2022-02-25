package domain;

import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGame {
    private final int purchasePrice;
    private final Lottos lottos = new Lottos();

    public LottoGame(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void start() {
        lottos.createLotto(purchasePrice);
        lottos.print();
        WiningNumber winingNumber = new WiningNumber(InputView.winningNumber());
        Map<Rank, Integer> winingResult = lottos.checkWiningNumber(winingNumber);
        printGameResult(winingResult);
    }

    private void printGameResult(Map<Rank, Integer> winingResult) {
        OutputView.printStatisticalResult(winingResult);
        OutputView.printBenefitPercentage(lottos.calculateRateBenefit(winingResult, purchasePrice));
    }

}
