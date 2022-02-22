package app.lotto.domain;

public enum LottoPrize {
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private long prizeMoney;
    private int count;
    private boolean isBonus;

    LottoPrize(long prizeMoney, int count, boolean isBonus) {
        this.prizeMoney = prizeMoney;
        this.count = count;
        this.isBonus = isBonus;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }

    public int getCount() {
        return count;
    }
}
