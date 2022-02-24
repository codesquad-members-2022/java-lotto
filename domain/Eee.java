package PACKAGE_NAME.domain;

public enum Eee {

    FIRST(6, "[1등] 6개 번호 일치", new Money()),
    SECOND(5, "[2등] 5개 번호 일치", new Money()),
    THIRD(4, "[3등] 4개 번호 일치", new Money()),
    FOURTH(3, "[4등] 3개 번호 일치", new Money()),
    DEFAULT(0, "[5등, 6등] 2개 이하 번호 일치", new Money());

    private final int matchCount;
    private final String description;
    private final Money winningPrize;

    Eee(int matchCount, String description, Money winningPrize) {
        this.matchCount = matchCount;
        this.description = description;
        this.winningPrize = winningPrize;
    }
}
