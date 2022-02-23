package lotto.controller;

import lotto.domain.LottoPaper;
import lotto.domain.LottoStore;
import lotto.domain.WinningStrategy;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        String inputWinningNumbers = InputView.getRequiredWinningNumber();
        String inputBonusNumber = InputView.getBonusBallNumber();

        List<Integer> winningNumbers = getWinningNumbers(inputWinningNumbers);
        int bonusNumber = getBonusNumber(inputBonusNumber);

        List<Integer> correctNumberCounts = lottoPaper.judgeWinning(winningNumbers);
        List<Boolean> hasBonusNumbers = lottoPaper.hasBonusNumbers(bonusNumber);

        return IntStream.range(0, correctNumberCounts.size())
                .mapToObj(index -> convertMatchNumberToWinningStrategy(correctNumberCounts.get(index), hasBonusNumbers.get(index)))
                .collect(Collectors.toList());
    }

    private List<Integer> getWinningNumbers(String inputWinningNumbers) {
        return Arrays.stream(inputWinningNumbers.split(NUMBER_DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private int getBonusNumber(String inputBonusNumber) {
        return Integer.parseInt(inputBonusNumber);
    }

    private WinningStrategy convertMatchNumberToWinningStrategy(int matchNumber, boolean hasBonusNumber) {
        if (matchNumber == WinningStrategy.ZERO_MATCHES.getCorrectNumber()) {
            return WinningStrategy.ZERO_MATCHES;
        }
        if (matchNumber == WinningStrategy.ONE_MATCHES.getCorrectNumber()) {
            return WinningStrategy.ONE_MATCHES;
        }
        if (matchNumber == WinningStrategy.TWO_MATCHES.getCorrectNumber()) {
            return WinningStrategy.TWO_MATCHES;
        }
        if (matchNumber == WinningStrategy.THREE_MATCHES.getCorrectNumber()) {
            return WinningStrategy.THREE_MATCHES;
        }
        if (matchNumber == WinningStrategy.FOUR_MATCHES.getCorrectNumber()) {
            return WinningStrategy.FOUR_MATCHES;
        }
        if (matchNumber == WinningStrategy.FIVE_MATCHES.getCorrectNumber() && hasBonusNumber) {
            return WinningStrategy.FIVE_WITH_BONUS_MATCHES;
        }
        if (matchNumber == WinningStrategy.FIVE_MATCHES.getCorrectNumber()) {
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
