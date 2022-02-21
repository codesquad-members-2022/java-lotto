import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domains.Lotto;
import domains.Lottos;

public class Main {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_MAX_LIMITED_NUMBER = 46;
	private static final int NUMBER_OF_AUTO_MAX = 6;
	private static Lottos lottos = new Lottos();

	public static void main(String[] args) {
		int purchaseAmount = getPurchaseAmount();
		int ticketAccount = getTicketAccount(purchaseAmount);

		ArrayList<Integer> lottoNumbers = getLottoNumbers();
		bulidLottos(ticketAccount, lottoNumbers);
		List<List<Integer>> purchasedLottos = lottos.getPurchasedLottos();

		purchaseHistory(purchasedLottos);

		scanClose();
	}

	private static void bulidLottos(int ticketAccount, ArrayList<Integer> lottoNumbers) {
		for (int i = 0; i < ticketAccount; i++) {
			mixNumber(lottoNumbers);
			ArrayList<Integer> autoPickedNumber = pickAutoLottoNumber(lottoNumbers);
			lottos.purchased(autoPickedNumber);
		}
	}

	private static void purchaseHistory(List<List<Integer>> purchasedLottos) {
		for (List<Integer> lotto : purchasedLottos) {
			prints.accept(lotto);
		}
	}

	private static ArrayList<Integer> getLottoNumbers() {
		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		for (int i = LOTTO_START_NUMBER; i < LOTTO_MAX_LIMITED_NUMBER; i++) {
			lottoNumbers.add(i);
		}
		return lottoNumbers;
	}

	private static ArrayList<Integer> pickAutoLottoNumber(ArrayList<Integer> lottoNumbers) {
		ArrayList<Integer> autoPickedNumber = new ArrayList<>();
		for (int j = 0; j < NUMBER_OF_AUTO_MAX; j++) {
			autoPickedNumber.add(lottoNumbers.get(j));
		}
		return autoPickedNumber;
	}

	private static void mixNumber(ArrayList<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}
}
