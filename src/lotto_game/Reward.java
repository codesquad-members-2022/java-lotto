package lotto_game;

public enum Reward {
    SIX_NUMBER_MATCH(6, 2000000000),
    FIVE_NUMBER_MATCH(5, 1500000),
    FOUR_NUMBER_MATCH(4, 50000),
    THREE_NUMBER_MATCH(3, 5000);


    private int countOfMatch;
    private int winningMoney;

    Reward(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
