package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class BonusNumber {

    private final int value;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;


    public BonusNumber(int value) {
        validateNumber(value);
        this.value = value;
    }

    private void validateNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isAnswer(List<Integer> answers) {
        return answers.contains(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public boolean isElementsOf(Set<Integer> winningNumbers) {
        return winningNumbers.contains(this.value);
    }
}
