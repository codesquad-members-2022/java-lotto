package domain.lotto;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    SECOND(5, 30_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    FAILED(-1, 0L);

    private final int countOfMatch;
    private final long reward;

    Rank(int contOfMatch, long reward) {
        this.countOfMatch = contOfMatch;
        this.reward = reward;
    }

    public long getReward() {
        return reward;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        switch (matchCount) {
            case 6 :
                return FIRST;
            case 5 :
                return matchBonus? SECOND : THIRD;
            case 4 :
                return FOURTH;
            case 3 :
                return FIFTH;
            default :
                return FAILED;
        }
    }

    @Override
    public String toString() {
        if (this == SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치(%d원)", countOfMatch, reward);
        }
        return String.format("%d개 일치, (%d원)", countOfMatch, reward);
    }
}
