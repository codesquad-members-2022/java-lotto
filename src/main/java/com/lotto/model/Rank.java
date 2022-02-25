package com.lotto.model;

import java.util.Arrays;
import java.util.stream.Collectors;

public enum Rank {
	FIFTH(3, 5_000),
	FOURTH(4, 50_000),
	THIRD(5, 15_000_000),
	SECOND(5, 30_000_000),
	FIRST(6, 2_000_000_000);

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
		if (count == SECOND.count) {
			return bonus ? SECOND : THIRD;
		}
		return getRankByCount(count);
	}

	private static Rank getRankByCount(int count) {
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.count == count)
			.collect(Collectors.toList()).get(0);
	}
}
