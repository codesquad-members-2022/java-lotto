package lotto.domain;

public class LottoNumber {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    private final int number;

    public LottoNumber(int number) {
        validateRange(number);
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (super.equals(obj)) {
            return true;
        }

        if (obj instanceof LottoNumber) {
            return ((LottoNumber) obj).getNumber() == this.number;
        }

        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    private void validateRange(int number) {
        validateMinimum(number);
        validateMaximum(number);
    }

    private void validateMaximum(int number) {
        if (number > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d보다 작아야 합니다.", MAXIMUM_NUMBER));
        }
    }

    private void validateMinimum(int number) {
        if (number < MINIMUM_NUMBER) {
            throw new IllegalArgumentException(String.format("로또 번호는 %d보다 커야 합니다.", MINIMUM_NUMBER));
        }
    }
}
