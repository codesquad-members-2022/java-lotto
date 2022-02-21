import static views.Input.*;
import static views.Output.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domains.Lotto;

public class Main {
	public static void main(String[] args) {
		println.accept("구입금액을 입력해 주세요.");
		int purchaseAmount = nextInt();

		int ticketAccount = purchaseAmount / 1000;
		println.accept(ticketAccount+"개를 구매했습니다.");


		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			lottoNumbers.add(i);
		}

		ArrayList<Lotto> lottos = new ArrayList<>();
		for (int i = 0; i < ticketAccount; i++) {
			mixNumber(lottoNumbers);
			ArrayList<Integer> autoPickedNumber = new ArrayList<>();
			for (int j = 0; j < 6; j++) {
				autoPickedNumber.add(lottoNumbers.get(j));
			}
			Lotto lotto = new Lotto(autoPickedNumber);
			lottos.add(lotto);
		}

		List<List<Integer>> purchasedLottos = new ArrayList<>();
		for (int i = 0; i < lottos.size(); i++) {
			Lotto lotto = lottos.get(i);
			List<Integer> numbers = lotto.numbers();
			purchasedLottos.add(numbers);
		}

		for (List<Integer> lotto : purchasedLottos) {
			prints.accept(lotto);
		}

		scanClose();
	}

	private static void mixNumber(ArrayList<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}
}
