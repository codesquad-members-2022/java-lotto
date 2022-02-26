package domains.user;

import java.util.List;

import domains.winning.BonusWinningNumbers;
import domains.winning.Ranking;
import view.PurchasedLotto;

public class UserLotto {
	private final LottoMachine lottoMachine;
	private final Lottos lottos;

	public UserLotto(LottoMachine lottoMachine, Lottos lottos) {
		this.lottoMachine = lottoMachine;
		this.lottos = lottos;
	}

	public Tickets getTickets(PurchasedLotto purchasedLotto) {
		Tickets tickets = lottoMachine.getTicket(purchasedLotto.getNumberOfTicket());
		lottos.of(tickets);
		return tickets;
	}

	public Ranking getRankingFromWinningNumbers(List<Integer> inputValueOfWinningNumbers, int bonusNumber) {
		BonusWinningNumbers winningNumbers = new BonusWinningNumbers(inputValueOfWinningNumbers, bonusNumber);
		Ranking ranking = lottos.getNumberOfWinningAboveThree(winningNumbers);
		return ranking;
	}
}
