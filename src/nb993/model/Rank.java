package nb993.model;

public enum Rank {

    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    NOTHING(0, false, 0);

    private int countOfMatch;
    private int winningMoney;
    private boolean hasBonus;

    private Rank(int countOfMatch, boolean hasBonus, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.hasBonus = hasBonus;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean hasBonus() {
        return hasBonus;
    }

    public static Rank valueOf(int countOfMatch, boolean hasBonus) {
        Rank[] ranks = values();
        for (Rank rank : ranks) {
            if (countOfMatch == SECOND.countOfMatch) {
                return hasBonus ? SECOND : THIRD;
            }

            if (rank.countOfMatch == countOfMatch) {
                return rank;
            }
        }
        return NOTHING;
    }

    @Override
    public String toString() {
        if (this.hasBonus) {
            return this.countOfMatch + "개 일치, 보너스 볼 일치 (" + this.winningMoney + "원)";
        }
        return this.countOfMatch + "개 일치 (" + this.winningMoney + "원)";
    }
}
