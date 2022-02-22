package domain;

public enum ProfitAmount {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FORTH(3, 5000);

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
