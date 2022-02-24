package domains;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Ranking {
	public static final int TO_PERCENT = 100;
	private Map<Rank, Integer> ranks = new LinkedHashMap<>();
	private Winnings winnings;

	public Ranking(Winnings winnings) {
		this.ranks = initializeRanks();
		this.winnings = winnings;
	}

	public enum Rank {
		FOURTH(3, "3개", Money.of(5000)),
		THIRD(4,"4개", Money.of(50_000)),
		SECOND(5,"5개", Money.of(1_500_000)),
		FIRST(6,"6개", Money.of(2_000_000_000));

		private int count;
		private String textOfCount;
		private Money money;

		Rank(int count, String textOfCount, Money money) {
			this.count = count;
			this.textOfCount = textOfCount;
			this.money = money;
		}

		private boolean isSame(int number) {
			return count == number;
		}

		private Rank of(int number) {
			return Arrays.stream(values())
				.filter(ranks -> ranks.isSame(number))
				.findFirst().get();
		}

		public String getText() {
			return textOfCount;
		}

		public String money() {
			return money.text();
		}

		public int amount() {
			return this.money.amount();
		}
	}

	private static Map<Rank, Integer> initializeRanks() {
		Map<Rank, Integer> results = new LinkedHashMap<>();
		for (Rank rank : Rank.values()) {
			results.put(rank, 0);
		}
		return results;
	}

	public Map<Rank, Integer> resultOfRanks() {
		Map<Integer, Integer> counts = this.winnings.getCounts();
		for (Integer key : counts.keySet()) {
			Rank rank = findRank(key);
			this.ranks.put(rank, counts.get(key));
		}
		return this.ranks;
	}

	private Rank findRank(Integer key) {
		return Arrays.stream(Rank.values()).map(rank -> rank.of(key)).findFirst().get();
	}

	/*
		수익률(%) = 손익/투자원금 * 100 = (평가금액-투자원금)/투자원금 * 100
	 */
	public double totalYields(int purchaseAmount) {
		Map<Integer, Integer> counts = this.winnings.getCounts();
		double totalEarningsByRank = 0;
		for (Integer key : counts.keySet()) {
			Rank rank =  findRank(key);
			int amount = rank.amount();
			totalEarningsByRank += amount * counts.get(key);
		}
		double profit = (totalEarningsByRank - purchaseAmount) / purchaseAmount;
		double rateOfReturn = profit * TO_PERCENT;
		return rateOfReturn;
	}
}
