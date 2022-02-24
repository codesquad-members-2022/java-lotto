package domains.winnings;

import static views.Output.*;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

import domains.users.Money;

public class Ranking {
	public static final int TO_PERCENT = 100;
	private Map<Rank, Integer> ranks = new LinkedHashMap<>();

	public Ranking() {
		this.ranks = initializeRanks();
	}

	private enum Rank {
		NONE(0, "0개", Money.of(0)),
		FOURTH(3, "3개", Money.of(5000)),
		THIRD(4,"4개", Money.of(50_000)),
		SECOND(5,"5개", Money.of(1_500_000)),
		BONUS_BALL(5, "5개 일치, 보너스 볼 일치", Money.of(30_000_000)),
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

		private Rank from(int count) {
			return Arrays.stream(values())
				.filter(ranks -> ranks.isSame(count))
				.findAny()
				.orElse(Rank.NONE);
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

	public void record(boolean checkedBonus, int winningCount) {
		if (winningCount != 4) {
			includeRank(winningCount);
			return;
		}
		toBonus(checkedBonus, winningCount);
	}

	private void toBonus(boolean checkedBonus, int winningCount) {
		if (checkedBonus) {
			includeBonusRank();
			return;
		}
		includeRank(winningCount);
	}

	private void includeRank(int winningCount) {
		Rank rank = findRank(winningCount);
		this.ranks.put(rank, this.ranks.getOrDefault(rank, 0)+1);
	}

	public void includeBonusRank() {
		this.ranks.put(Rank.BONUS_BALL, this.ranks.getOrDefault(Rank.BONUS_BALL, 0)+1);
	}

	private Rank findRank(Integer count) {
		for (Rank rank : Rank.values()) {
			return rank.from(count);
		}
		return Rank.NONE;
	}

	/*
		수익률(%) = 손익/투자원금 * 100 = (평가금액-투자원금)/투자원금 * 100
	 */
	public double totalYields(int purchaseAmount) {
		double totalEarningsByRank = 0;
		for (Rank rank : this.ranks.keySet()) {
			int amount = rank.amount();
			Integer numberOfMachedLotto = this.ranks.get(rank);
			totalEarningsByRank += amount * numberOfMachedLotto;
		}
		double profit = (totalEarningsByRank - purchaseAmount) / purchaseAmount;
		double rateOfReturn = profit * TO_PERCENT;
		return rateOfReturn;
	}

	public String getWinningStatistics() {
		StringBuilder sb = new StringBuilder();
		sb.append(OUTPUT_WINNING_STATISTICS)
			.append(System.lineSeparator())
			.append(OUTPUT_WINNING_STATISTICS_LINE)
			.append(System.lineSeparator());
		rankLines(sb);
		return sb.toString();
	}

	private void rankLines(StringBuilder sb) {
		for (Ranking.Rank rank : ranks.keySet()) {
			if (rank.NONE.isSame(rank.count)) {
				continue;
			}
			sb.append(rank.getText())
				.append(OUTPUT_IDX_FIRST)
				.append(rank.money())
				.append(OUTPUT_IDX_SECOND)
				.append(ranks.get(rank))
				.append(OUTPUT_IDX_THIRD)
				.append(System.lineSeparator());
		}
	}

	public String getRateOfReturn(int purchaseAmount) {
		double yields = totalYields(purchaseAmount);
		StringBuilder sb = new StringBuilder();
		sb.append(OUTPUT_TOTAL_YIELD_MESSAGE);
		DecimalFormat df = new DecimalFormat(PATTERN_ROUND_DOWN);
		df.setRoundingMode(RoundingMode.DOWN);
		String rateOfReturn = df.format(yields);
		sb.append(rateOfReturn)
			.append(OUTPUT_TOTAL_YIELD_MESSAGE_SUFFIX);
		return sb.toString();
	}
}
