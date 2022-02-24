package domain;

public enum Rank {
    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(7, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchedNumber;
    private final int prize;

    private Rank(int matchedNumber, int prize) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank designateRank(int matchedNumber) {
        switch (matchedNumber) {
            case 3:
                return FIFTH;
            case 4:
                return FORTH;
            case 5:
                return THIRD;
            case 7:
                return SECOND;
            default:
                return FIRST;
        }
    }
}
