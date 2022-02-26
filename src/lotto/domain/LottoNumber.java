package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	private static final String ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE = "로또번호는 1~45 범위의 숫자로 입력해주세요.";
	public static final int MIN_VALUE = 1;
	public static final int MAX_VALUE = 45;

	public LottoNumber(int number) throws IllegalArgumentException {
		validateRange(number);
		this.number = number;
	}

	private void validateRange(int lottoNumber) {
		boolean isValidRangeLottoNumber = lottoNumber >= MIN_VALUE && lottoNumber <= MAX_VALUE;
		if (!isValidRangeLottoNumber) {
			throw new IllegalArgumentException(ERROR_MESSAGE_FOR_LOTTO_NUMBER_RANGE);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoNumber that = (LottoNumber) o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}


	@Override
	public String toString() {
		return String.valueOf(number);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return this.number - o.number;
	}
}
