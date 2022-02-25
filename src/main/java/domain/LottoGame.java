package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int LOTTO_SIZE = 6;

    private final int purchasePrice;
    private final List<Integer> winingNumber = new ArrayList<>();
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

        for (int index = 0; index < LOTTO_SIZE; index++) {
            winingNumber.add(Integer.parseInt(winningNumber[index]));
        }

        bonusNumber = Integer.parseInt(InputView.bonusNumber());
    }

}
