package domains;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
	private final List<Integer> sixNumbers;

	public Lotto(List<Integer> sixNumbers) {
		if (Objects.isNull(sixNumbers)) {
			throw new NullPointerException("NPE - lotto");
		}
		if (sixNumbers.size() < 6) {
			throw new IllegalArgumentException("error of lotto params");
		}
		Collections.sort(sixNumbers);
		this.sixNumbers = sixNumbers;
	}

	public List<Integer> numbers() {
		return this.sixNumbers;
	}

	public int numberOfWinnings(List<Integer> winningNumbers){
		long count = winningNumbers.stream()
				.filter(sixNumbers::contains)
				.count();

		return Long.valueOf(count).intValue();
	}
}
