package domain;

public enum Rank {
    FIRST(6, 2000000000),
    BONUS_SECOND(5, 30000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(0, 0);

    private final int winningCount;
    private final int prize;

    Rank(int winningCount, int prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public static Rank getRank(int resultIndex) {
        switch (resultIndex) {
            case 7:
                return BONUS_SECOND;
            case 6:
                return FIRST;
            case 5:
                return SECOND;
            case 4:
                return THIRD;
            case 3:
                return FOURTH;
            default:
                return LOSE;
        }
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrize() {
        return prize;
    }
}
