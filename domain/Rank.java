package PACKAGE_NAME.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, "[1등] 6개 번호 일치", new Money()),
    BONUS(6, true, "[2등] 5개 번호 일치, 1개 보너스 볼 일치", new Money()),
    SECOND(5, false, "[2등] 5개 번호 일치", new Money()),
    THIRD(4, false, "[3등] 4개 번호 일치", new Money()),
    FOURTH(3, false, "[4등] 3개 번호 일치", new Money()),
    NO_MATCH(0, false, "[5등, 6등] 2개 이하 번호 일치", new Money());

    private final int matchCount;
    private final boolean bonus;
    private final String description;
    private final Money winningPrize;

    Rank(int matchCount, boolean bonus, String description, Money winningPrize) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.description = description;
        this.winningPrize = winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank getRank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findAny()
                .orElse(NO_MATCH);
    }
}
