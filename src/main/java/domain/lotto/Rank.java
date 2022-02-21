package domain.lotto;

public enum Rank {
    FIRST(2000000000),
    SECOND(1500000),
    THIRD(50000),
    FOURTH(5000),
    FAILED(0);


    private final int reward;

    Rank(int reward) {
        this.reward = reward;
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
