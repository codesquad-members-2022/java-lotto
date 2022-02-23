package domainTest;

import domain.Ball;
import domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    Lotto winningLotto;

    @BeforeEach
    void setUp() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Set<Ball> winningBalls = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            winningBalls.add(new Ball(numbers[i]));
        }
        winningLotto = new Lotto(winningBalls);
    }

    @Test
    @DisplayName("두 Lotto의 같은 Ball의 수를 리턴한다.")
    void matchBallCountTest() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        Set<Ball> balls = new HashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            balls.add(new Ball(numbers[i]));
        }

        int[] numbers1 = {1, 3, 5, 7, 8, 9};
        Set<Ball> balls1 = new HashSet<>();
        for (int i = 0; i < numbers1.length; i++) {
            balls1.add(new Ball(numbers1[i]));
        }

        Lotto lotto1 = new Lotto(balls);
        Lotto lotto2 = new Lotto(balls1);

        assertThat(winningLotto.getMatchBallCount(lotto1)).isEqualTo(6);
        assertThat(winningLotto.getMatchBallCount(lotto2)).isEqualTo(3);
    }

    @Test
    @DisplayName("로또는 중복된 숫자를 가지거나 6개의 볼을 가지지 않으면 예외를 발생시킨다.")
    void throwLottoTest() {
        int[] numbers1 = {6, 6, 6, 4, 5, 6};
        Set<Ball> balls1 = new HashSet<>();
        for (int i = 0; i < numbers1.length; i++) {
            balls1.add(new Ball(numbers1[i]));
        }

        int[] numbers2 = {1, 3, 5, 7, 8, 9, 10};
        Set<Ball> balls2 = new HashSet<>();
        for (int i = 0; i < numbers2.length; i++) {
            balls2.add(new Ball(numbers2[i]));
        }

        int[] numbers3 = {1, 3, 5, 7, 8};
        Set<Ball> balls3 = new HashSet<>();
        for (int i = 0; i < numbers3.length; i++) {
            balls3.add(new Ball(numbers3[i]));
        }

        assertThatThrownBy(() -> new Lotto(balls1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 총 6개의 숫자를 필요로 합니다.(중복숫자 불가능)");
        assertThatThrownBy(() -> new Lotto(balls2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 총 6개의 숫자를 필요로 합니다.(중복숫자 불가능)");
        assertThatThrownBy(() -> new Lotto(balls3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 총 6개의 숫자를 필요로 합니다.(중복숫자 불가능)");
    }

    @Test
    @DisplayName("같은 공을 가지고 있으면 true를 반환한다.")
    void isMatchBonusBall() {
        Ball ball1 = new Ball(6);
        Ball ball2 = new Ball(7);

        assertThat(winningLotto.isMatchBonusBall(ball1)).isTrue();
        assertThat(winningLotto.isMatchBonusBall(ball2)).isFalse();
    }
}
