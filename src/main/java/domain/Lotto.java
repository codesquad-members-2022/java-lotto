package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Ball> balls;

    public Lotto(List<Ball> balls) {
        this.balls = balls;
    }

    public List<Integer> getBallNumbers() {
        return balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toList());
    }

    public int getMatchBallCount(Lotto winningLotto) {
        return (int) winningLotto.balls.stream()
                .filter(balls::contains).count();
    }

    public boolean isMatchBonusBall(Ball bonusBall) {
        return balls.contains(bonusBall);
    }
}
