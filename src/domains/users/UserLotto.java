package domains.users;

import java.util.ArrayList;
import java.util.List;

import domains.winnings.BonusWinningNumbers;
import domains.winnings.Ranking;
import views.PurchasedLotto;

public class UserLotto {
	private final LottoMachine lottoMachine;
	private final Lottos lottos;

	public UserLotto(LottoMachine lottoMachine, Lottos lottos) {
		this.lottoMachine = lottoMachine;
		this.lottos = lottos;
	}

	public List<List<Integer>> getTickets(PurchasedLotto purchasedLotto) {
		ArrayList<ArrayList<Integer>> tickets = lottoMachine.getTicket(purchasedLotto.getNumberOfTicket());
		return lottos.getTotalLottos(tickets);
	}

	public Ranking getRankingFromWinningNumbers(List<Integer> inputValueOfWinningNumbers, int bonusNumber) {
		BonusWinningNumbers winningNumbers = new BonusWinningNumbers(inputValueOfWinningNumbers, bonusNumber);
		Ranking ranking = lottos.getNumberOfWinningAboveThree(winningNumbers);
		return ranking;
	}
}
