package lotto.domain;

public enum PrizeDivision {
    MATCH_OF_THREE(3, 5_000),
    MATCH_OF_FOUR(4, 50_000),
    MATCH_OF_FIVE(5, 1_500_000),
    MATCH_OF_SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeValue;

    PrizeDivision(int matchCount, int prizeValue) {
        this.matchCount = matchCount;
        this.prizeValue = prizeValue;
    }

    public static PrizeDivision getWhichDivision(int matchCount) {
        switch (matchCount) {
            case 3:
                return MATCH_OF_THREE;
            case 4:
                return MATCH_OF_FOUR;
            case 5:
                return MATCH_OF_FIVE;
            case 6:
                return MATCH_OF_SIX;
            default:
                return null;
        }
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeValue() {
        return prizeValue;
    }
}

