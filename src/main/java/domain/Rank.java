package domain;

public enum Rank {
    FOURTH(5000),
    THIRD(50000),
    SECOND(1500000),
    FIRST(2000000000);

    private static final Rank[] RANK_ARR = Rank.values();

    private int winningMoney;

    Rank(int winningMoney) {
        this.winningMoney = winningMoney;
    }

    public static int getWinningMoney(int num) {
        return RANK_ARR[num - 3].winningMoney;
    }

}
