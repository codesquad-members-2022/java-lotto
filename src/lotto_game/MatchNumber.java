package lotto_game;

public enum MatchNumber {
    SIX(2000000000),
    FIVE_CONTAIN_BONUS(30000000),
    FIVE(1500000),
    FOUR(50000),
    THREE(5000),
    ZERO_TO_TWO(0);

    private int winnings;

    MatchNumber(int winnings) {
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }
}
