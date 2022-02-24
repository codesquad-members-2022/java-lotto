package domain;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String LOTTO_BALLS_ERROR = "로또는 총 6개의 숫자를 필요로 합니다.(중복숫자 불가능)";

    private final Set<Ball> balls;

    public Lotto(Set<Ball> balls) {
        if(balls.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_BALLS_ERROR);
        }
        this.balls = balls;
    }

    public List<String> getStringBalls() {
        return balls.stream()
                .map(Ball::getNumber)
                .map(String::valueOf)
                .collect(Collectors.toList());
    }

    public int getMatchBallCount(WinningLotto winningLotto) {
        return (int) winningLotto.getLotto().balls.stream()
                .filter(this.balls::contains).count();
    }

    public boolean isMatchBonusBall(WinningLotto winningLotto) {
        return winningLotto.isMatch(balls);
    }

}
