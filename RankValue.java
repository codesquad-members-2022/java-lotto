public enum RankValue {

    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    NOTHING(0, 0);

    private int countOfMatch;
    private int winningMoney;

    RankValue(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static RankValue valueOf(int countOfMatch, boolean matchBonus) {
        if (countOfMatch == FIFTH.countOfMatch) return FIFTH;
        if (countOfMatch == FOURTH.countOfMatch) return FOURTH;
        if (countOfMatch == SECOND.countOfMatch) return matchBonus ? SECOND : THIRD;
        if (countOfMatch == FIRST.countOfMatch) return FIRST;

        return NOTHING;
    }
}
