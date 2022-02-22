package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoStore;
import lotto.domain.WinningStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private static final String NUMBER_DELIMITER = ",";

    public void start() {
        InputView.init();

        int purchaseAmount = InputView.getPurchaseAmount();
        LottoPaper lottoPaper = purchase(purchaseAmount);

        List<WinningStrategy> winningStrategies = checkWinning(lottoPaper);

        calculateWinningStats(winningStrategies, purchaseAmount);

        InputView.close();
    }

    private LottoPaper purchase(int purchaseAmount) {
        LottoStore lottoStore = new LottoStore();
        LottoPaper lottoPaper = lottoStore.purchase(purchaseAmount);

        OutputView.printPurchaseCount(lottoPaper.getLottoSize());
        OutputView.printLottoPaper(lottoPaper.showLottoPaper());

        return lottoPaper;
    }

    private List<WinningStrategy> checkWinning(LottoPaper lottoPaper) {
        String stringWinningNumbers = InputView.getRequiredWinningNumber();
        List<Integer> winningNumbers = getWinningNumbers(stringWinningNumbers);
        List<Integer> correctNumberCounts = lottoPaper.judgeWinning(winningNumbers);

        List<WinningStrategy> winningStrategies = new ArrayList<>();
        for (int eachNumber : correctNumberCounts) {
            winningStrategies.add(convertMatchNumberToWinningStrategy(eachNumber));
        }

        return winningStrategies;
    }

    private List<Integer> getWinningNumbers(String stringWinningNumbers) {
        List<Integer> winningNumbers = new ArrayList<>();
        String[] eachNumber = stringWinningNumbers.split(NUMBER_DELIMITER);

        for (String number : eachNumber) {
            winningNumbers.add(Integer.parseInt(number));
        }

        return winningNumbers;
    }

    private WinningStrategy convertMatchNumberToWinningStrategy(int matchNumber) {
        if (matchNumber == 0) {
            return WinningStrategy.ZERO_MATCHES;
        }
        if (matchNumber == 1) {
            return WinningStrategy.ONE_MATCHES;
        }
        if (matchNumber == 2) {
            return WinningStrategy.TWO_MATCHES;
        }
        if (matchNumber == 3) {
            return WinningStrategy.THREE_MATCHES;
        }
        if (matchNumber == 4) {
            return WinningStrategy.FOUR_MATCHES;
        }
        if (matchNumber == 5) {
            return WinningStrategy.FIVE_MATCHES;
        }
        return WinningStrategy.SIX_MATCHES;
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
