package model;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 30_000_000),
	THIRD(5, 15_000_000),
	FOURTH(4, 50_000),
	FIFTH(3, 5_000);

	private int count;
	private int winningAmount;

	Rank(int count, int winningAmount) {
		this.count = count;
		this.winningAmount = winningAmount;
	}

	public int getCount() {
		return count;
	}

	public int getWinningAmount() {
		return winningAmount;
	}

	public static Rank checkRank(int count, boolean bonus) {

		for (Rank rank : Rank.values()) {
			if (count == SECOND.count) {
				return bonus ? SECOND : THIRD;
			}
			if (count == rank.count)
				return rank;
		}
		return null;
	}
}
