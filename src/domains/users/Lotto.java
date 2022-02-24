package domains.users;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
	public static final String ERROR_OF_LOTTO_PARAMS = "error of lotto params";
	private final List<Integer> sixNumbers;

	public Lotto(List<Integer> sixNumbers) {
		if (Objects.isNull(sixNumbers)) {
			throw new IllegalArgumentException(ERROR_OF_LOTTO_PARAMS);
		}
		if (sixNumbers.size() < 6) {
			throw new IllegalArgumentException(ERROR_OF_LOTTO_PARAMS);
		}
		Collections.sort(sixNumbers);
		this.sixNumbers = sixNumbers;
	}

	public List<Integer> numbers() {
		return this.sixNumbers;
	}

	public int countNumberOfWinnings(List<Integer> winningNumbers){
		int count = 0;
		for (Integer winningNumber : winningNumbers) {
			count = getCount(count, winningNumber);
		}
		return count;
	}

	private int getCount(int count, Integer winningNumber) {
		if (sixNumbers.contains(winningNumber)) {
			count++;
		}
		return count;
	}

	public boolean getBonus(int bonusNumber) {
		if (sixNumbers.contains(bonusNumber)){
			return true;
		}
		return false;
	}
}
