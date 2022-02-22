package application;

public enum Prize {
    THREE(3, 5_000),
    FOUR(4, 10_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    final int matchCount;
    final int reward;

    Prize(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public static Prize create(int count) {
        switch (count) {
            case 3:
                return Prize.THREE;
            case 4:
                return Prize.FOUR;
            case 5:
                return Prize.FIVE;
            case 6:
                return Prize.SIX;
        }
        return null;
    }
}
