package PACKAGE_NAME.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, false, "[1등] 6개 번호 일치", new Money(2_000_000_000)),
    BONUS(6, true, "[2등] 5개 번호 일치, 1개 보너스 볼 일치", new Money(30_000_000)),
    SECOND(5, false, "[2등] 5개 번호 일치", new Money(1_500_000)),
    THIRD(4, false, "[3등] 4개 번호 일치", new Money(50_000)),
    FOURTH(3, false, "[4등] 3개 번호 일치", new Money(5_000)),
    NO_MATCH(0, false, "[5등, 6등] 2개 이하 번호 일치", new Money(0));

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

    public Money getWinningPrize() {
        return winningPrize;
    }

    public static Rank getRank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .findAny()
                .orElse(NO_MATCH);
    }
}
