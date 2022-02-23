package domain;

import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    private static final String LOTTO_BALLS_ERROR = "로또는 총 6개의 숫자를 필요로 합니다.(중복숫자 불가능)";
    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        if(balls.size() != 6) {
            throw new IllegalArgumentException(LOTTO_BALLS_ERROR);
        }
        this.balls = balls;
    }

    public Set<Integer> getBallNumbers() {
        return balls.stream()
                .map(Ball::getNumber)
                .collect(Collectors.toSet());
    }

    public int getMatchBallCount(Lotto winningLotto) {
        return (int) winningLotto.balls.stream()
                .filter(balls::contains).count();
    }

    public boolean isMatchBonusBall(Ball bonusBall) {
        return balls.contains(bonusBall);
    }
}
