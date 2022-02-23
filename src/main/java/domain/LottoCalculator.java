package domain;

import view.OutputView;

import java.util.List;

public class LottoCalculator {

    public void operate(List<Lotto> lottos, int[] winingNumber, int money) {
        int[] result = new int[7];

        for (Lotto lotto : lottos) {
            int rank = lotto.check(winingNumber);
            result[rank]++;
        }

        OutputView.printStatisticalResult(result);
        OutputView.printBenefitPercentage(calculateRateBenefit(result, money));

    }

    private double calculateRateBenefit(int[] result, int money) {
        double benefit = 0;

        for (int index = 3; index < result.length; index++) {
            benefit += Rank.getWinningMoney(index) * result[index];
        }

        return ((benefit / money) - 1) * 100;
    }

}
