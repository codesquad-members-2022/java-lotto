package domain;

public enum ProfitAmount {
    FORTH(3, 5000),
    THIRD(4, 50000),
    SECOND(5, 1500000),
    FIRST(6, 2000000000);

    private final int matchedNumber;
    private final int prize;

    ProfitAmount(int matchedNumber, int prize) {
        this.matchedNumber = matchedNumber;
        this.prize = prize;
    }

    public int getMatchedNumber() {
        return matchedNumber;
    }

    public int getPrize(){
        return prize;
    }
}
