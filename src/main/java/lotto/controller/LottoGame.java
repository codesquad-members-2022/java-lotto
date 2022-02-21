package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoStore;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final String NUMBER_DELIMITER = ",";

    public void start() {
        InputView.init();

        int purchaseAmount = InputView.getPurchaseAmount();

        LottoStore lottoStore = new LottoStore();
        LottoPaper lottoPaper = lottoStore.purchase(purchaseAmount);

        OutputView.printPurchaseCount(lottoPaper.getLottoSize());
        OutputView.printLottoPaper(lottoPaper.showLottoPaper());

        String stringWinningNumbers = InputView.getRequiredWinningNumber();
        InputView.close();
        List<Integer> winningNumbers = getWinningNumbers(stringWinningNumbers);

        List<Integer> correctCounts = lottoPaper.judgeWinning(winningNumbers);
//        calculateRank(correctCounts);
        // 수익률 계산

//        OutputView.printWinningStats();

    }

    private List<Integer> getWinningNumbers(String stringWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] eachNumber = stringWinningNumbers.split(NUMBER_DELIMITER);

        for (String number : eachNumber) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    /**
     * 각 등수별로 몇 개가 당첨되었는지 리턴
     * 3개부터 6개까지만 카운트
     * @param correctCounts
     * @return
     */
//    private List<Integer> calculateRank(List<Integer> correctCounts) {
//
//    }

    /**
     * 수익률 계산 공식
     * ((당첨금액 / 구매금액) * 100) - 100
     * @return
     */
//    private double calculateProfit() {
//
//    }
}
