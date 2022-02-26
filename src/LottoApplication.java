import static view.Input.*;
import static view.Output.*;

import java.util.List;

import domains.user.LottoMachine;
import domains.user.Lottos;
import domains.user.Tickets;
import domains.winning.Ranking;
import domains.user.UserLotto;
import view.PurchasedLotto;

public class LottoApplication {
	private static LottoMachine lottoMachine = new LottoMachine();
	private static Lottos lottos = new Lottos();
	private static UserLotto userLotto = new UserLotto(lottoMachine, lottos);

	public static void main(String[] args) {
		PurchasedLotto purchasedLotto = purchaseLotto();

		Tickets totalLottos = userLotto.getTickets(purchasedLotto);
		showLottos(totalLottos);

		Ranking ranking = userLotto.getRankingFromWinningNumbers(inputWinningNumbers(), getBonusNumber());
		getResultOfLotto(ranking, purchasedLotto.getPurchaseAmount());

		scanClose();
	}
}
