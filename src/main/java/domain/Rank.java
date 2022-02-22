package domain;

public enum Rank {
    rank1(2000000000, 6, false),
    rank2(30000000, 5, true),
    rank3(1500000, 5, false),
    rank4(50000, 4, false),
    rank5(5000, 3, false),
    noRank(0, 0, false);

    private int prize;
    private int matchedCount;
    private boolean containsBonus;

    Rank(int prize, int match, boolean containsBonus) {
        this.prize = prize;
        this.matchedCount = match;
        this.containsBonus = containsBonus;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean containsBonus() {
        return containsBonus;
    }

    public static Rank getMatchedRank(int matchedCount, boolean containsBonus) {
        // TODO : 리팩토링(depth 줄이기)
        for (Rank rank : values()) {
            if (rank.getMatchedCount() == matchedCount) {
                if (matchedCount == 5) {
                    return (rank.containsBonus() == containsBonus) ? rank2 : rank3;
                }
                return rank;
            }
        }
        return noRank;
    }
}
