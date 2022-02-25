package lotto.domain;

public enum WinningStrategy {
    ZERO_MATCHES(0, 0),
    ONE_MATCHES(1, 0),
    TWO_MATCHES(2, 0),
    THREE_MATCHES(3, 5_000),
    FOUR_MATCHES(4, 50_000),
    FIVE_MATCHES(5, 1_500_000),
    FIVE_WITH_BONUS_MATCHES(5, 30_000_000),
    SIX_MATCHES(6, 2_000_000_000);

    private final int correctNumber;
    private final int winningPrice;


    WinningStrategy(int correctNumber, int winningPrice) {
        this.correctNumber = correctNumber;
        this.winningPrice = winningPrice;
    }

    public int getWinningPrice() {
        return this.winningPrice;
    }

    public int getCorrectNumber() {
        return this.correctNumber;
    }
}
