package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private static final String NUMBER_DELIMITER = ",";

    public void start() {
        InputView.init();

        int purchaseAmount = InputView.getPurchaseAmount();
        int manualLottoCount = InputView.getManualLottoCount();

        LottoPaper lottoPaper = purchase(
                purchaseAmount,
                manualLottoCount,
                getManualNumbers(InputView.getManualLottoNumbers(manualLottoCount)));

        calculateWinningStats(checkWinning(lottoPaper), purchaseAmount);

        InputView.close();
    }

    private LottoPaper purchase(int purchaseAmount, int manualLottoCount, Map<Integer, List<Integer>> numbers) {
        LottoPaper lottoPaper = new LottoStore().purchase(purchaseAmount, manualLottoCount, numbers);

        OutputView.printPurchaseCount(manualLottoCount, lottoPaper.getLottoSize() - manualLottoCount);
        OutputView.printLottoPaper(lottoPaper.showLottoPaper());

        return lottoPaper;
    }

    private List<WinningStrategy> checkWinning(LottoPaper lottoPaper) {
        List<Integer> winningNumbers = getNumbers(InputView.getRequiredWinningNumber());
        int bonusNumber = getBonusNumber(InputView.getBonusBallNumber(winningNumbers));

        return lottoPaper.checkWinning(new WinningLotto(winningNumbers, bonusNumber));
    }

    private List<Integer> getNumbers(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(NUMBER_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private Map<Integer, List<Integer>> getManualNumbers(Map<Integer, String> inputNumbers) {
        Map<Integer, List<Integer>> manualNumbers = new HashMap<>();

        for (int i = 0; i < inputNumbers.size(); i++) {
             manualNumbers.put(i, getNumbers(inputNumbers.get(i)));
        }

        return manualNumbers;
    }

    private int getBonusNumber(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }

    private void calculateWinningStats(List<WinningStrategy> winningStrategies, int purchaseAmount) {
        long winningPrices = winningStrategies.stream()
                .mapToLong(WinningStrategy::getWinningPrice)
                .sum();
        double profit = calculateProfit(purchaseAmount, winningPrices);

        OutputView.printWinningStats(winningStrategies, profit);
    }

    private double calculateProfit(int purchaseAmount, long winningPrices) {
        return (((double) winningPrices / (double) purchaseAmount) * 100) - 100;
    }
}
