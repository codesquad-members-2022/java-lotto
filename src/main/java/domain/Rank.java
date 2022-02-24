package domain;

public enum Rank {
    FIFTH(5000, 3),
    FOURTH(50000, 4),
    THIRD(1500000, 5),
    SECOND(30000000, 5),
    FIRST(2000000000, 6);

    private static final Rank[] RANK_ARR = Rank.values();

    private final int winningMoney;
    private final int matchCount;

    Rank(int winningMoney, int matchCount) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
    }

    public static Rank aaa(int count) {
        for (Rank rank : RANK_ARR) {
            if (rank.getMatchCount() == count) {
                return rank;
            }
        }
        return null;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
