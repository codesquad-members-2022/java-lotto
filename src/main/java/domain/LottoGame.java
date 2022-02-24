package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private static final int LOTTO_SIZE = 6;
    private static final int LOTTO_FIRST_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private final int purchasePrice;
    private final int[] winingNumber = new int[LOTTO_SIZE];
    private final Lottos lottos = new Lottos();
    private int bonusNumber;

    public LottoGame(int purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void start() {
        lottos.createLotto(purchasePrice, createLottoBalls());
        lottos.print();
        createWiningNumber();
        Map<Rank, Integer> winingResult = lottos.checkWiningNumber(winingNumber);
        printGameResult(winingResult);
    }

    private void printGameResult(Map<Rank, Integer> winingResult) {
        OutputView.printStatisticalResult(winingResult);
        OutputView.printBenefitPercentage(lottos.calculateRateBenefit(winingResult, purchasePrice));
    }

    private void createWiningNumber() {
        String[] split = InputView.winningNumber().split(", ");

        for (int index = 0; index < winingNumber.length; index++) {
            winingNumber[index] = Integer.parseInt(split[index]);
        }

         bonusNumber = Integer.parseInt(InputView.bonusNumber());
    }

    private List<Integer> createLottoBalls() {
        List<Integer> lottoBalls = new ArrayList<>();

        for (int lottoBall = LOTTO_FIRST_NUMBER; lottoBall <= LOTTO_LAST_NUMBER; lottoBall++) {
            lottoBalls.add(lottoBall);
        }

        return lottoBalls;
    }

}
