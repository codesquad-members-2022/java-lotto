public enum Rank {
    FOURTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private static final Rank[] RANK_ARR = Rank.values();

    private int correctNumber;
    private int winningMoney;

    Rank(int correctNumber,int winningMoney ) {
        this.correctNumber = correctNumber;
        this.winningMoney = winningMoney;
    }

    public static int aaa(int num) {
        return RANK_ARR[num-3].getWinningMoney();
    }

    public int getCorrectNumber() {
        return correctNumber;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

}
