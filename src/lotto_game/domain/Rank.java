package lotto_game.domain;

public enum Rank {
    FIRST(2000000000),
    SECOND(30000000),
    THIRD(1500000),
    FOURTH(50000),
    FIFTH(5000),
    NO_RANK(0);

    private int winnings;

    Rank(int winnings) {
        this.winnings = winnings;
    }

    public int getWinnings() {
        return winnings;
    }
}
