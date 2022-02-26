package PACKAGE_NAME.domain;

import java.util.Objects;
import java.util.Set;

public class BonusNumber {

    private final int bonusNumber;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 45;

    public BonusNumber(int bonusNumber) {
        validateNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateNumber(int value) {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isElementsOf(Set<LottoNumber> winningNumbers) {
        return winningNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BonusNumber that = (BonusNumber) o;
        return bonusNumber == that.bonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(bonusNumber);
    }
}
