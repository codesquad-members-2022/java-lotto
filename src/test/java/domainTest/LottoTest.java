package domainTest;

import domain.Ball;
import domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    Lotto winningLotto;

    @BeforeEach
    void setUp() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        List<Ball> winningBalls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            winningBalls.add(new Ball(numbers[i]));
        }
        winningLotto = new Lotto(winningBalls);
    }

    @Test
    @DisplayName("두 Lotto의 같은 Ball의 수를 리턴한다.")
    void matchBallCountTest() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        List<Ball> balls = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            balls.add(new Ball(numbers[i]));
        }

        int[] numbers1 = {1, 3, 5, 7, 8, 9};
        List<Ball> balls1 = new ArrayList<>();
        for (int i = 0; i < numbers1.length; i++) {
            balls1.add(new Ball(numbers1[i]));
        }

        Lotto lotto1 = new Lotto(balls);
        Lotto lotto2 = new Lotto(new ArrayList<>());
        Lotto lotto3 = new Lotto(balls1);

        assertThat(winningLotto.getMatchBallCount(lotto1)).isEqualTo(6);
        assertThat(winningLotto.getMatchBallCount(lotto2)).isEqualTo(0);
        assertThat(winningLotto.getMatchBallCount(lotto3)).isEqualTo(3);
    }

}
