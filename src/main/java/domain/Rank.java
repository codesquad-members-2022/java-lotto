package domain;

public enum Rank {
    FAIL(0, 0),
    FIFTH(3, 5_000),
    FORTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
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

    public static Rank designateRank(int matchedNumber, boolean isBonus) {
        switch (matchedNumber) {
            case 3:
                return FIFTH;
            case 4:
                return FORTH;
            case 5:
                return checkBonus(isBonus);
            case 6:
                return FIRST;
            default:
                return FAIL;
        }
    }

    private static Rank checkBonus(boolean isBonus){
        if(isBonus)
            return SECOND;
        return THIRD;
    }
}
