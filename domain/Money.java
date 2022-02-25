package PACKAGE_NAME.domain;

import java.util.Objects;

public class Money {

    private final int value;
    public static final Money ZERO = new Money(0);
    private static final String WON = "원";

    public Money(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public Money add(Money money) {
        return new Money(this.value+ money.getValue());
    }

    public Money multiply(int count) {
        return new Money(count * value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return value == money.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value + WON;
    }
}
