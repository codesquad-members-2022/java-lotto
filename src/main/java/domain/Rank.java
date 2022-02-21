package domain;

public enum Rank {
    rank1(2000000000, 6),
    rank2(1500000, 5),
    rank3(50000, 4),
    rank4(5000, 3),
    noRank(0, 0);

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

    public static Rank getMatchedRank(int match) {
        for (Rank rank : values()) {
            if (rank.getMatch() == match) {
                return rank;
            }
        }
        return noRank;
    }
}
