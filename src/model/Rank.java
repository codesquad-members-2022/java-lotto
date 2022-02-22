package model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
	FIRST(6, 2_000_000_000),
	SECOND(5, 15_000_000),
	THIRD(4, 50_000),
	FOURTH(3, 5_000);

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

	public static Rank checkRank(int count){
		return Arrays.stream(Rank.values())
			.filter(r -> r.getCount() == count)
			.collect(Collectors.toList())
			.get(0);
	}
}
