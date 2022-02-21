package app.lotto.domain;

public enum LottoPrize {
    FOURTH(5_000, 3),
    THIRD(50_000, 4),
    SECOND(1_500_000, 5),
    FIRST(2_000_000_000, 6);

    private long prizeMoney;
    private int count;

    LottoPrize(long prizeMoney, int count) {
        this.prizeMoney = prizeMoney;
        this.count = count;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}
