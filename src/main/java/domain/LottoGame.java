package domain;

import view.InputView;
import view.OutputView;

import java.util.Map;

public class LottoGame {
    private static final int LOTTO_SIZE = 6;

    private final int purchasePrice;
    private final int[] winingNumber = new int[LOTTO_SIZE];
    private final Lottos lottos = new Lottos();
    private int bonusNumber;

    public LottoGame(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void start() {
        lottos.createLotto(purchasePrice);
        lottos.print();
        createWiningNumber();
        Map<Rank, Integer> winingResult = lottos.checkWiningNumber(winingNumber, bonusNumber);
        printGameResult(winingResult);
    }

    private void printGameResult(Map<Rank, Integer> winingResult) {
        OutputView.printStatisticalResult(winingResult);
        OutputView.printBenefitPercentage(lottos.calculateRateBenefit(winingResult, purchasePrice));
    }

    private void createWiningNumber() {
        String[] winningNumber = InputView.winningNumber();

        for (int index = 0; index < winingNumber.length; index++) {
            winingNumber[index] = Integer.parseInt(winningNumber[index]);
        }

         bonusNumber = Integer.parseInt(InputView.bonusNumber());
    }

}
