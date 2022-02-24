import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.List;

import domains.LottoMachine;
import domains.Lottos;
import domains.Ranking;
import domains.WinningNumbers;

public class LottoPlay {
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

		List<Integer> inputValueOfWinningNumbers = inputWinningNumbers();
		int bonusNumber = getBonusNumber();

		WinningNumbers winningNumbers = new WinningNumbers(inputValueOfWinningNumbers, bonusNumber);
		Ranking ranking = lottos.getNumberOfWinningAboveThree(winningNumbers);

		getResultOfLotto(ranking, purchaseAmount);

		scanClose();
	}

	private static void getResultOfLotto(Ranking ranking, int purchaseAmount) {
		String winningStatistics = ranking.getWinningStatistics();
		String rateOfReturn = ranking.getRateOfReturn(purchaseAmount);
		printResultOfLottoAndYield(winningStatistics, rateOfReturn);
	}
}
