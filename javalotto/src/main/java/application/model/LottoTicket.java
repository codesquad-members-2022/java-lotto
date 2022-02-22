package application.model;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import application.domain.Lotto;
import application.domain.WinningData;
import application.view.InputView;
import application.view.OutputView;

public class LottoTicket {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 46;
    private static final int AMOUNT_LOTTO_NUMBER = 6;
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int SIZE_OF_ANSWER_ARRAY = 8;
    private static final int TWO_LOTTO_LENGTH_SUM = 12;
    private static final int INDEX_OF_BONUS_BALL = 7;

    public void init() {
        List<Lotto> lottos = makeLotto();
        List<Integer> userWinningNumber = InputView.getWinningNumber();
        int bonusBallNumber = InputView.getBonusBall();
        start(lottos, userWinningNumber, bonusBallNumber);
    }

    private void start(List<Lotto> lottos, List<Integer> userWinningNumber, int bonusBallNumber) {
        int[] counts = makeStatistics(lottos, userWinningNumber, bonusBallNumber);
        double totalYield = calculateYield(counts);
        OutputView.printWinningStatistics(counts, totalYield);
    }

    private double calculateYield(int[] counts) {
        int userPurchaseAmount = Arrays.stream(counts).sum() * LOTTO_TICKET_PRICE;
        double currentYield = 0;
        for (int winningCount = 3; winningCount <= 7; winningCount++) {
            currentYield += WinningData.getWinningData(winningCount) * counts[winningCount];
        }
        return (currentYield - userPurchaseAmount) / userPurchaseAmount * 100;
    }

    private int[] makeStatistics(List<Lotto> lottos, List<Integer> userWinningNumber, int bonusBallNumber) {
        Set<Integer> userWinningNumberSet = new HashSet<>(userWinningNumber);

        int[] counts = new int[SIZE_OF_ANSWER_ARRAY];
        int count;
        for (var lotto : lottos) {
            Set<Integer> lottoSet = new HashSet<>(lotto.getNumbers());
            lottoSet.addAll(new HashSet<>(userWinningNumberSet));
            count = TWO_LOTTO_LENGTH_SUM - lottoSet.size();
            if (count == 5) {
                int tmp = lotto.getNumbers().contains(bonusBallNumber) ? 1 : 0;
                counts[INDEX_OF_BONUS_BALL] += tmp;
                counts[5] -= tmp;
            }
            counts[count] += 1;
        }
        return counts;
    }

    private List<Lotto> makeLotto() {
        List<Lotto> lottos = new ArrayList<>();
        int userPurchaseAmount = InputView.getPurchaseAmount();
        int userPurchaseQuantity = userPurchaseAmount / LOTTO_TICKET_PRICE;
        OutputView.printPurchaseQuantity(userPurchaseQuantity);
        for (int i = 0; i < userPurchaseQuantity; i++) {
            Lotto tempLotto = new Lotto(createNumbers());
            lottos.add(tempLotto);
            OutputView.printLottoNumbers(tempLotto.getNumbers());
        }
        return lottos;
    }

    private List<Integer> createNumbers() {
        return new SecureRandom()
                .ints(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
                .parallel()
                .distinct()
                .limit(AMOUNT_LOTTO_NUMBER)
                .boxed()
                .sorted()
                .collect(Collectors.toList());
    }
}
