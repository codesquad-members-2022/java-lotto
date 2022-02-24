package domains.users;

import java.util.ArrayList;
import java.util.Collections;

public class LottoMachine {
	private static final int LOTTO_START_NUMBER = 1;
	private static final int LOTTO_MAX_LIMITED_NUMBER = 46;
	private static final int RANGE_OF_AUTO_MAX = 6;

	public ArrayList<ArrayList<Integer>> getTicket(int numberOfTicket) {
		ArrayList<Integer> lottoNumbers = getLottoNumbers();
		ArrayList<ArrayList<Integer>> picked = new ArrayList<>();
		for (int i = 0; i < numberOfTicket; i++) {
			mixNumber(lottoNumbers);
			ArrayList<Integer> autoPicked = pickAutoSixNumber(lottoNumbers);
			picked.add(autoPicked);
		}
		return picked;
	}

	private ArrayList<Integer> getLottoNumbers() {
		ArrayList<Integer> lottoNumbers = new ArrayList<>();
		for (int i = LOTTO_START_NUMBER; i < LOTTO_MAX_LIMITED_NUMBER; i++) {
			lottoNumbers.add(i);
		}
		return lottoNumbers;
	}

	private void mixNumber(ArrayList<Integer> lottoNumbers) {
		Collections.shuffle(lottoNumbers);
	}

	private ArrayList<Integer> pickAutoSixNumber(ArrayList<Integer> lottoNumbers) {
		ArrayList<Integer> autoPickedNumber = new ArrayList<>();
		for (int j = 0; j < RANGE_OF_AUTO_MAX; j++) {
			autoPickedNumber.add(lottoNumbers.get(j));
		}
		return autoPickedNumber;
	}
}
