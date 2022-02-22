package application.domain;

public enum WinningData {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000),
    BONUS(7, 3000000);

    private final int winningCount;
    private final int reward;

    WinningData(int winningCount, int reward) {
        this.winningCount = winningCount;
        this.reward = reward;
    }

    public static int getWinningData(int winningCount) {
        for (var data : WinningData.values()) {
            if (data.isSameWinningCount(winningCount)) {
                return data.reward;
            }
        }
        throw new IllegalArgumentException();
    }

    public boolean isSameWinningCount(int winningCount) {
        return this.winningCount == winningCount;
    }

}
