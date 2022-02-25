package PACKAGE_NAME.domain;

import java.util.Arrays;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public enum Rank {

    FIRST(6, FALSE, "6개 일치 (2000000000원)- ", new Money(2_000_000_000)),
    BONUS(6, TRUE, "5개 일치, 보너스 볼 일치(30000000원)- ", new Money(30_000_000)),
    SECOND(5, FALSE, "5개 일치 (1500000원)- ", new Money(1_500_000)),
    THIRD(4, FALSE, "4개 일치 (50000원)- ", new Money(50_000)),
    FOURTH(3, FALSE, "3개 일치 (5000원)- ", new Money(5_000)),
    NO_MATCH(0, FALSE, "2개 이하 번호 일치 (0원)- ", new Money(0));

    private final int matchCount;
    private final Boolean bonus;
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

    private Boolean getBonus() {
        return bonus;
    }

    public String getDescription() {
        return description;
    }

    public static Rank getRank(int matchCount, Boolean bouns) {
        return Arrays.stream(values())
                .filter(rank -> rank.getMatchCount() == matchCount)
                .filter(rank -> rank.getBonus() == bouns)
                .findAny()
                .orElse(NO_MATCH);
    }
}
