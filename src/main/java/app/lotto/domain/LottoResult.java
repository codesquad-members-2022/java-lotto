package app.lotto.domain;

import app.lotto.domain.LottoPrize;

public class LottoResult {

    private final LottoPrize lottoPrize;
    private final int winningCaseCount;

    public LottoResult(LottoPrize lottoPrize, int winningCaseCount) {
        this.lottoPrize = lottoPrize;
        this.winningCaseCount = winningCaseCount;
    }

    public LottoPrize getLottoPrize() {
        return lottoPrize;
    }

    public int getWinningCaseCount() {
        return winningCaseCount;
    }
}
