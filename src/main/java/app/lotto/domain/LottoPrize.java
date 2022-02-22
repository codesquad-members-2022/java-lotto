package app.lotto.domain;

import java.util.Optional;

public enum LottoPrize {
    FIFTH(5_000, 3, false),
    FOURTH(50_000, 4, false),
    THIRD(1_500_000, 5, false),
    SECOND(30_000_000, 5, true),
    FIRST(2_000_000_000, 6, false);

    private final long prizeMoney;
    private final int count;
    private final boolean isBonus;

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

    public static Optional<LottoPrize> findLottoPrize(int count, boolean isBonus) {
        // 찾는 로직
        for (LottoPrize lottoPrize : values()) {
            if (isLottoPrize(lottoPrize, count, isBonus)) return Optional.of(lottoPrize);
        }

        return Optional.empty();
    }

    public static boolean isLottoPrize(int count, boolean isBonus) {
        // 찾는 로직
        for (LottoPrize lottoPrize : values()) {
            if (isLottoPrize(lottoPrize, count, isBonus)) return true;
        }

        return false;
    }

    private static boolean isLottoPrize(LottoPrize lottoPrize, int count, boolean isBonus) {
        return count == lottoPrize.count && lottoPrize.isBonus == isBonus;
    }
}
