package lotto.domain;

public enum WinningPrice {
    FOURTH_PRIZE(5_000),
    THIRD_PRIZE(50_000),
    SECOND_PRIZE(1_500_000),
    FIRST_PRIZE(2_000_000_000);

    private int winningPrice;

    WinningPrice(int winningPrice) {
        this.winningPrice = winningPrice;
    }
}
