package domain.lotto;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    FAILED(-1, 0);

    private final int countOfMatch;
    private final int reward;

    Rank(int contOfMatch, int reward) {
        this.countOfMatch = contOfMatch;
        this.reward = reward;
    }

    public int getReward() {
        return reward;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public static Rank of(long matchCount) {
        switch ((int) matchCount) {
            case 6:
                return FIRST;
            case 5:
                return SECOND;
            case 4:
                return THIRD;
            case 3:
                return FOURTH;
            default:
                return FAILED;
        }
    }
}
