package domains;

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
		this.sixNumbers = sixNumbers;
	}

	public List<Integer> numbers() {
		return this.sixNumbers;
	}
}
