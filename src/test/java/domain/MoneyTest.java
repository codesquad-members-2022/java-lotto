package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    @DisplayName("정상인경우")
    void createMoney() {
        Money money = new Money(1000);

        assertThat(money.getPurchaseAmount()).isEqualTo(1000L);
    }

    @Test
    @DisplayName("음수일 때 Money 생성 시 예외 발생")
    void purchaseAmountLessThanPriceOfLotto() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1000의 배수가 아닐 때 Money 생성 시 예외 발생")
    void multipleOfPrice() {
        assertThatThrownBy(() -> new Money(1001))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
