package views;

import java.util.List;
import java.util.function.Consumer;

import domains.winnings.Ranking;

public class Output {
	public static final String PATTERN_ROUND_DOWN = "0.00";
	public static final String OUTPUT_IDX_FIRST = " 일치 (";
	public static final String OUTPUT_IDX_SECOND = ") - ";
	public static final String OUTPUT_IDX_THIRD = "개";
	public static final String OUTPUT_WINNING_STATISTICS = "당첨 통계";
	public static final String OUTPUT_WINNING_STATISTICS_LINE = "--------------------";
	public static final String OUTPUT_TOTAL_YIELD_MESSAGE = "총 수익율은 ";
	public static final String OUTPUT_TOTAL_YIELD_MESSAGE_SUFFIX = "%입니다";

	public static Consumer<String> print = (text) -> System.out.print(text);
	public static Consumer<String> println = (text) -> System.out.println(text);
	public static Consumer<Object> prints = (obj) -> System.out.println(obj);

	public static void showLottos(List<List<Integer>> purchasedLottos) {
		for (List<Integer> lotto : purchasedLottos) {
			prints.accept(lotto);
		}
	}
	public static void printResultOfLottoAndYield(String winningStatistics, String rateOfReturn) {
		println.accept(winningStatistics);
		println.accept(rateOfReturn);
	}

	public static void getResultOfLotto(Ranking ranking, int purchaseAmount) {
		String winningStatistics = ranking.getWinningStatistics();
		String rateOfReturn = ranking.getRateOfReturn(purchaseAmount);
		printResultOfLottoAndYield(winningStatistics, rateOfReturn);
	}

}
