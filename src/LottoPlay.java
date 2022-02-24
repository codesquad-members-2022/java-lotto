import static views.Input.*;
import static views.Output.*;

import java.util.List;

import domains.LottoMachine;
import domains.Lottos;
import domains.Ranking;
import domains.UserLotto;
import views.PurchasedLotto;

public class LottoPlay {
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
