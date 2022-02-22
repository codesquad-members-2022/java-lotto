public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000);

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

    public static Rank create(int countOfMatch) {
        switch (countOfMatch) {
            case 3:
                return Rank.FORTH;
            case 4:
                return Rank.THIRD;
            case 5:
                return Rank.SECOND;
            case 6:
                return Rank.FIRST;
            default:
                return null;
        }
    }
}
