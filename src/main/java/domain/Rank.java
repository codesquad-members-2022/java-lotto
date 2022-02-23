package domain;

public enum Rank {
    FORTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchedNumber;
    private final int prize;

    private Rank(int matchedNumber, int prize) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize(){
        return prize;
    }

    public static Rank designateRank(int matchedNumber) {
        switch (matchedNumber) {
            case 3:
                return FORTH;
            case 4:
                return THIRD;
            case 5:
                return SECOND;
            default:
                return FIRST;
        }
    }
}
