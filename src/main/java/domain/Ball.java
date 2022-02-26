package domain;

import java.util.Objects;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    private final int number;

    public Ball(int number) {
        if (MIN_NUMBER > number || number > MAX_NUMBER) {
            throw new IllegalArgumentException("범위를 벗어났습니다.");
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
