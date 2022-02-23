package domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final String NUMBER_ERROR_MESSAGE = "1~45 사이의 수를 입력해주세요";
    private static final int LOWER_BOUND_NUMBER = 1;
    private static final int UPPER_BOUND_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException(NUMBER_ERROR_MESSAGE);
        }
        this.number = number;
    }

    private boolean isValidNumber(int number) {
        return number >= LOWER_BOUND_NUMBER && number <= UPPER_BOUND_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public int compareTo(LottoNumber o) {
        return this.number - o.number;
    }

    public boolean isSameNumber(int number) {
        return this.number == number;
    }
}
