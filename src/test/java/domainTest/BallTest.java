package domainTest;

import domain.Ball;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class BallTest {

    @Test
    @DisplayName("숫자 공은 1부터 45까지만 생성할 수 있다.")
    void createBallTest() {
        assertThatNoException().isThrownBy(() -> new Ball(1));
        assertThatNoException().isThrownBy(() -> new Ball(45));
        assertThatThrownBy(() -> new Ball(0)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Ball(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
