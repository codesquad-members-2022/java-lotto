import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domains.Lotto;

public class Main {

	public static final int PRICE_OF_ONE_LOTTO = 1000;
	public static final String OUTPUT_ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
	public static final String OUTPUT_NUMBER_OF_PURCHASED = "개를 구매했습니다.";
	public static final int LOTTO_START_NUMBER = 1;
	public static final int LOTTO_MAX_LIMITED_NUMBER = 46;
	public static final int NUMBER_OF_AUTO_MAX = 6;

	public static void main(String[] args) {
		println.accept(OUTPUT_ASK_PURCHASE_AMOUNT);
		int purchaseAmount = nextInt();

		int ticketAccount = purchaseAmount / PRICE_OF_ONE_LOTTO;
		println.accept(informPurchasing(ticketAccount));

		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		for (int i = LOTTO_START_NUMBER; i < LOTTO_MAX_LIMITED_NUMBER; i++) {
			lottoNumbers.add(i);
		}

		ArrayList<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < ticketAccount; i++) {
			mixNumber(lottoNumbers);
			ArrayList<Integer> autoPickedNumber = pickAutoLottoNumber(lottoNumbers);
			Lotto lotto = new Lotto(autoPickedNumber);
			lottos.add(lotto);
		}

		List<List<Integer>> purchasedLottos = new ArrayList<>();
		for (Lotto lotto : lottos) {
			List<Integer> numbers = lotto.numbers();
			purchasedLottos.add(numbers);
		}

		for (List<Integer> lotto : purchasedLottos) {
			prints.accept(lotto);
		}

		scanClose();
	}

	private static ArrayList<Integer> pickAutoLottoNumber(ArrayList<Integer> lottoNumbers) {
		ArrayList<Integer> autoPickedNumber = new ArrayList<>();
		for (int j = 0; j < NUMBER_OF_AUTO_MAX; j++) {
			autoPickedNumber.add(lottoNumbers.get(j));
		}
		return autoPickedNumber;
	}

	private static String informPurchasing(int ticketAccount) {
		return ticketAccount + OUTPUT_NUMBER_OF_PURCHASED;
	}

	private static void mixNumber(ArrayList<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}
}
