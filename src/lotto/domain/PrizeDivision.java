package lotto.domain;

import java.util.stream.Stream;

public enum PrizeDivision {
    MATCH_OF_THREE(3, 5_000),
    MATCH_OF_FOUR(4, 50_000),
    MATCH_OF_FIVE(5, 1_500_000),
    MATCH_OF_FIVE_WITH_BONUS(5, 300_000_000),
    MATCH_OF_SIX(6, 2_000_000_000);

    private final int matchCount;
    private final int prizeValue;

    PrizeDivision(int matchCount, int prizeValue) {
        this.matchCount = matchCount;
        this.prizeValue = prizeValue;
    }

    public static PrizeDivision getWhichDivision(int matchCount, boolean hasBonusNumber) {
        if (matchCount == MATCH_OF_FIVE_WITH_BONUS.matchCount && hasBonusNumber) {
            return MATCH_OF_FIVE_WITH_BONUS;
        }

        return Stream.of(values())
                .filter(d -> d.matchCount == matchCount)
                .findAny()
                .orElse(null);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrizeValue() {
        return prizeValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d개 일치", matchCount));

        if (this == MATCH_OF_FIVE_WITH_BONUS) {
            sb.append(", 보너스 볼 일치");
        }

        return sb.append(String.format(" (%,d원)", prizeValue)).toString();
    }
}

