package domain;

public enum Rank {
    FIFTH(3, 5_000, false),
    FORTH(4, 50_000, false),
    THIRD(5, 1_500_000, false),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000, false);

    private final int matchedNumber;
    private final int prize;
    private final boolean isBonus;

    private Rank(int matchedNumber, int prize, boolean isBonus) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
        this.isBonus = isBonus;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize() {
        return prize;
    }

    public static Rank designateRank(int matchedNumber, boolean isBonus) {
        switch (matchedNumber) {
            case 3:
                return FIFTH;
            case 4:
                return FORTH;
            case 5:
                if (isBonus)
                    return SECOND;
                return THIRD;
            default:
                return FIRST;
        }
    }
}
