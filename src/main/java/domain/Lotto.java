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
                .map(ball -> ball.getNumber())
                .collect(Collectors.toList());
    }

    public int getMatchBallCount(Lotto winningLotto) {
        List<Integer> lottoBallNumbers = winningLotto.getBallNumbers();
        return (int) getBallNumbers().stream()
                .filter(lottoBallNumbers::contains)
                .count();
    }
}
