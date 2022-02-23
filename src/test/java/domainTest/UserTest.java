package domainTest;

import domain.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class UserTest {

    @Test
    @DisplayName("유저는 수동횟수만큼만 로또를 구입할 수 있다.")
    void buyCustomLottoTest() {
        assertThatThrownBy(() -> new User(15000, 16))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액을 초과하였습니다.");
        assertThatNoException().isThrownBy(() -> new User(15000, 15));
    }
}
