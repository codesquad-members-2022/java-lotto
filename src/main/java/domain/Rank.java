package domain;

public enum Rank {
    FIFTH(5000, 3, "3개 일치"),
    FOURTH(50000, 4, "4개 일치"),
    THIRD(1500000, 5, "5개 일치"),
    SECOND(30000000, 5, "5개 일치, 보너스 볼 일치"),
    FIRST(2000000000, 6, "6개 일치");

    private static final Rank[] RANK_ARR = Rank.values();

    private final int winningMoney;
    private final int matchCount;
    private final String matchMessage;

    Rank(int winningMoney, int matchCount, String matchMessage) {
        this.winningMoney = winningMoney;
        this.matchCount = matchCount;
        this.matchMessage = matchMessage;
    }

    public static Rank checkRank(int matchedCount, boolean isMatchBonusNumber) {
        for (Rank rank : RANK_ARR) {
            if (rank.getMatchCount() == matchedCount) {
                return getRank(matchedCount, isMatchBonusNumber, rank);
            }
        }
        return null;
    }

    private static Rank getRank(int matchedCount, boolean isMatchBonusNumber, Rank rank) {
        if(5 == matchedCount && isMatchBonusNumber) {
            return SECOND;
        }
        return rank;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    @Override
    public String toString() {
        return matchMessage + "("+winningMoney+"원)";
    }

}
