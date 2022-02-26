package lotto.domain;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FORTH(4, 50000),
    FIFTH(3, 5000);

    private final int countOfMatch;
    private final int winningMoney;

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank create(int countOfMatch, boolean isMatchBonusNumber) {
        switch (countOfMatch) {
            case 3:
                return Rank.FIFTH;
            case 4:
                return Rank.FORTH;
            case 5:
                return isMatchBonusNumber ? Rank.SECOND : Rank.THIRD;
            case 6:
                return Rank.FIRST;
            default:
                return null;
        }
    }

    public static boolean isSecond(Rank rank) {
        if (rank.equals(Rank.SECOND)) {
            return true;
        }
        return false;
    }
}
