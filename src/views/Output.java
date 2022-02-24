package views;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import domains.Ranking;

public class Output {
	private static final String PATTERN_ROUND_DOWN = "0.00";
	private static final String OUTPUT_IDX_FIRST = " 일치 (";
	private static final String OUTPUT_IDX_SECOND = ") - ";
	private static final String OUTPUT_IDX_THIRD = "개";
	private static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
	private static final String OUTPUT_WINNING_STATISTICS_LINE = "--------------------";
	private static final String OUTPUT_TOTAL_YIELD_MESSAGE = "총 수익율은 ";
	private static final String OUTPUT_TOTAL_YIELD_MESSAGE_SUFFIX = "%입니다";

	public static Consumer<String> print = (text) -> System.out.print(text);
	public static Consumer<String> println = (text) -> System.out.println(text);
	public static Consumer<Object> prints = (obj) -> System.out.println(obj);

	public static void showLottos(List<List<Integer>> purchasedLottos) {
		for (List<Integer> lotto : purchasedLottos) {
			prints.accept(lotto);
		}
	}

	public static void printResultOfLottoAndYield(Map<Ranking.Rank, Integer> ranks, double yields) {
		String winningStatistics = getWinningStatistics(ranks);
		String rateOfReturn = getRateOfReturn(yields);
		println.accept(winningStatistics);
		println.accept(rateOfReturn);
	}

	private static String getWinningStatistics(Map<Ranking.Rank, Integer> ranks) {
		StringBuilder sb = new StringBuilder();
		sb.append(OUTPUT_WINNING_STATISTICS)
			.append(System.lineSeparator())
			.append(OUTPUT_WINNING_STATISTICS_LINE)
			.append(System.lineSeparator());
		rankLines(ranks, sb);
		return sb.toString();
	}

	private static void rankLines(Map<Ranking.Rank, Integer> ranks, StringBuilder sb) {
		for (Ranking.Rank rank : ranks.keySet()) {
			sb.append(rank.getText())
				.append(OUTPUT_IDX_FIRST)
				.append(rank.money())
				.append(OUTPUT_IDX_SECOND)
				.append(ranks.get(rank))
				.append(OUTPUT_IDX_THIRD)
				.append(System.lineSeparator());
		}
	}

	private static String getRateOfReturn(double yields) {
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
