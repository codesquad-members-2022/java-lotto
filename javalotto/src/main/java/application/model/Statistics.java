package application.model;

import java.util.Arrays;
import java.util.List;

import application.domain.Lotto;
import application.domain.WinningData;

public class Statistics {

    private static final int SIZE_OF_ANSWER_ARRAY = 8;

    private static final int INDEX_OF_BONUS_BALL = 7;
    private static final int LOTTO_TICKET_PRICE = 1000;

    private Statistics() {
    }

    public static double calculateYield(int[] counts) {
        int userPurchaseAmount = Arrays.stream(counts).sum() * LOTTO_TICKET_PRICE;
        double currentYield = 0;
        for (int winningCount = 3; winningCount <= 7; winningCount++) {
            currentYield += WinningData.getWinningData(winningCount) * counts[winningCount];
        }
        return (currentYield - userPurchaseAmount) / userPurchaseAmount * 100;
    }

    public static int[] makeStatistics(List<Lotto> lottos, Lotto userWinningNumber, int bonusBallNumber) {
        int[] counts = new int[SIZE_OF_ANSWER_ARRAY];
        for (var lotto : lottos) {
            int count = lotto.getTheNumberOfMatches(userWinningNumber);
            if (count == 5) {
                int tmp = lotto.isContainBonusBallNumber(bonusBallNumber) ? 1 : 0;
                counts[INDEX_OF_BONUS_BALL] += tmp;
                counts[5] -= tmp;
            }
            counts[count] += 1;
        }
        return counts;
    }
}
