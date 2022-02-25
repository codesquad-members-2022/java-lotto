import static views.Input.*;
import static views.Output.*;

import java.util.List;

import domains.users.LottoMachine;
import domains.users.Lottos;
import domains.winnings.Ranking;
import domains.users.UserLotto;
import views.PurchasedLotto;

public class LottoApplication {
	private static LottoMachine lottoMachine = new LottoMachine();
	private static Lottos lottos = new Lottos();
	private static UserLotto userLotto = new UserLotto(lottoMachine, lottos);

	public static void main(String[] args) {
		PurchasedLotto purchasedLotto = purchaseLotto();

		List<List<Integer>> totalLottos = userLotto.getTickets(purchasedLotto);
		showLottos(totalLottos);

		List<Integer> inputValueOfWinningNumbers = inputWinningNumbers();
		int bonusNumber = getBonusNumber();

		Ranking ranking = userLotto.getRankingFromWinningNumbers(inputValueOfWinningNumbers, bonusNumber);
		getResultOfLotto(ranking, purchasedLotto.getPurchaseAmount());

		scanClose();
	}
}
