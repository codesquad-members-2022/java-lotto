package domain;

public enum Rank {
    rank1(2000000000, 6),
    rank2(1500000, 5),
    rank3(50000, 4),
    rank4(5000, 3);

    private int prize;
    private int match;

    Rank(int prize, int match) {
        this.prize = prize;
        this.match = match;
    }

    public int getPrize() {
        return prize;
    }

    public int getMatch() {
        return match;
    }
}
