import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domains.LottoMachine;
import domains.Lottos;
import domains.Ranking;
import domains.WinningNumbersCounter;

public class Main {
	private static final int IDX_PURCHASED_AMOUNT = 0;
	private static final int IDX_NUMBER_OF_TICKET = 1;
	private static LottoMachine lottoMachine = new LottoMachine();
	private static Lottos lottos = new Lottos();

	public static void main(String[] args) {
		int[] purchasedLotto = purchaseLotto();
		int purchaseAmount = purchasedLotto[IDX_PURCHASED_AMOUNT];
		int numberOfTicket = purchasedLotto[IDX_NUMBER_OF_TICKET];

		ArrayList<ArrayList<Integer>> tickets = lottoMachine.getTicket(numberOfTicket);
		List<List<Integer>> totalLottos = lottos.getTotalLottos(tickets);
		showLottos(totalLottos);

		List<Integer> winningNumbers = inputWinningNumbers();
		List<Integer> threeOrMore = lottos.numberOfWinningAboveThree(winningNumbers);
		int bonusNumber = getBonusNumber();
		getResultOfLotto(purchaseAmount, threeOrMore);

		scanClose();
	}

	private static void getResultOfLotto(int purchaseAmount, List<Integer> threeOrMore) {
		WinningNumbersCounter winnings = new WinningNumbersCounter(threeOrMore);
		Ranking ranking = new Ranking(winnings);

		Map<Ranking.Rank, Integer> ranks = ranking.resultOfRanks();
		double yields = ranking.totalYields(purchaseAmount);
		printResultOfLottoAndYield(ranks, yields);
	}
}
