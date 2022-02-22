package domain;

import java.util.Objects;

public class Ball {

    private final int number;

    public Ball(int number) {
        if (1 > number || number > 45) {
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
