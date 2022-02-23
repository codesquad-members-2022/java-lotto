package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    private static final int DEFAULT_VALUE = 0;
    private static final int ONE_HUNDRED = 100;

    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;

    private static final int FOURTH_WINNING_AMOUNT = 5_000;
    private static final int THIRD_WINNING_AMOUNT = 50_000;
    private static final int SECOND_WINNING_AMOUNT = 1_500_000;
    private static final int FIRST_WINNING_AMOUNT = 2_000_000_000;


    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int winningAmount(Map<Integer, Integer> answers) {
        int sum = 0;

        for (int answerCount : answers.keySet()) {
            sum += getWinningAmount(answerCount) * answers.getOrDefault(answerCount, DEFAULT_VALUE);
        }
        return sum;
    }

    public double calculateYield(int sum, int inputMoney) {
        double yield = (sum - inputMoney) * ONE_HUNDRED / inputMoney;
        return Math.round(yield * ONE_HUNDRED) / ONE_HUNDRED;
    }

    private int getWinningAmount(int answerCount) {
        switch (answerCount) {
            case THREE:
                return FOURTH_WINNING_AMOUNT;
            case FOUR:
                return THIRD_WINNING_AMOUNT;
            case FIVE:
                return SECOND_WINNING_AMOUNT;
            case SIX:
                return FIRST_WINNING_AMOUNT;
            default:
                return DEFAULT_VALUE;
        }
    }

    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }
}