package domain;

public enum Rank {
    FIRST(6, false, 2000000000),
    SECOND(5,true, 30000000),
    THIRD(5,false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    FAIL(0, false, 0);

    private final int matchCount;
    private final boolean matchBonus;
    private final int price;

    Rank(int matchCount, boolean matchBonus, int price) {
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static Rank createRank(int matchCount, boolean matchBonus) {
        if (matchCount == FIRST.matchCount) {
            return FIRST;
        }
        if (matchCount == SECOND.matchCount && matchBonus) {
            return SECOND;
        }
        if (matchCount == THIRD.matchCount) {
            return THIRD;
        }
        if (matchCount == FOURTH.matchCount) {
            return FOURTH;
        }
        if (matchCount == FIFTH.matchCount) {
            return FIFTH;
        }
        return FAIL;
    }
}
