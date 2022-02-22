package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LuckyLotto {

	private final List<Integer> luckyNumbers;
	private int bounsNumber;

	public LuckyLotto(int[] luckyNumbers) {
		if (luckyNumbers.length != 6) {
			throw new IllegalArgumentException();
		}
		this.luckyNumbers = Arrays.stream(luckyNumbers)
			.boxed()
			.collect(Collectors.toList());
	}

	public List<Integer> getNumbers() {
		return List.copyOf(luckyNumbers);
	}

}
