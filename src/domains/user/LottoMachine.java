package domains.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_MAX_LIMITED_NUMBER = 46;
	private static final int RANGE_OF_AUTO_MAX = 6;

	public Tickets getTicket(int numberOfTicket) {
		List<Integer> lottoNumbers = getLottoNumbers();
		Tickets tickets = new Tickets();

		for (int i = 0; i < numberOfTicket; i++) {
			mixNumber(lottoNumbers);
			List<Integer> autoPicked = pickAutoSixNumber(lottoNumbers);
			tickets.takeIt(autoPicked);
		}
		return tickets;
	}

	private List<Integer> getLottoNumbers() {
		List<Integer> lottoNumbers = new ArrayList<>();
		for (int i = LOTTO_START_NUMBER; i < LOTTO_MAX_LIMITED_NUMBER; i++) {
			lottoNumbers.add(i);
		}
		return lottoNumbers;
	}

	private void mixNumber(List<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}

	private List<Integer> pickAutoSixNumber(List<Integer> lottoNumbers) {
		List<Integer> autoPickedNumber = new ArrayList<>();
		for (int j = 0; j < RANGE_OF_AUTO_MAX; j++) {
			autoPickedNumber.add(lottoNumbers.get(j));
		}
		return autoPickedNumber;
	}
}
