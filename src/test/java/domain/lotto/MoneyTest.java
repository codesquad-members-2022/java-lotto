package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("Money 클래스")
class MoneyTest {

    @Nested
    @DisplayName("생성자는")
    class Describe_constructor {
        @Nested
        @DisplayName("만약 구입금이 1000 이상의 1000의 배수일 경우")
        class Context_with_Multiple_of_1000 {
            @Test
            @DisplayName("구입금에 대응하는 Money 객체를 반환한다.")
            void it_returns_money_instance() {
                long purchaseAmount = 1000;
                Money money = new Money(purchaseAmount);

                long innerPurchaseAmount = money.getPurchaseAmount();
                assertThat(innerPurchaseAmount).isEqualTo(purchaseAmount);
            }
        }

        @Nested
        @DisplayName("만약 구입금이 경계값(1000)보다 작은 액수일 경우")
        class Context_with_less_than_1000 {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_returns_money_instance() {
                long purchaseAmount = 999;
                assertThatThrownBy(() -> new Money(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("만약 구입금이 경계값(1000)보다 크고, 1000의 배수가 아닐 경우")
        class Context_with_greater_than_1000_and_not_multiple_of_1000 {
            @Test
            @DisplayName("IllegalArgumentException을 throw한다.")
            void it_returns_money_instance() {
                long purchaseAmount = 1001;
                assertThatThrownBy(() -> new Money(purchaseAmount))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
