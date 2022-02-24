package domain;

import java.util.Arrays;

public enum Rank {
    RANK1(2_000_000_000, 6, false),
    RANK2(30_000_000, 5, true),
    RANK3(1_500_000, 5, false),
    RANK4(50_000, 4, false),
    rank5(5_000, 3, false),
    NO_RANK(0, 0, false);

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

    public static Rank getMatchedRank(int matchedCount, boolean containsBonus) {
        if (matchedCount == 5) {
            return (containsBonus) ? RANK2 : RANK3;
        }
        return Arrays.stream(Rank.values())
            .filter(r -> r.getMatchedCount() == matchedCount)
            .findAny()
            .orElse(Rank.NO_RANK);
    }
}
