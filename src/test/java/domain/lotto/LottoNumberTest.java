package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("LottoNumber 클래스")
class LottoNumberTest {

    @Nested
    @DisplayName("of 메서드는")
    class Describe_of {
        @Nested
        @DisplayName("만약 1~45 사이의 정수가 주어진다면")
        class Context_with_valid_parameter {
            @Test
            @DisplayName("해당 값에 해당하는 LottoNumber를 반환한다.")
            void it_returns_a_LottoNumber() {
                int number = 3;

                LottoNumber lottoNumber = LottoNumber.of(number);

                assertThat(lottoNumber.getNumber()).isEqualTo(number);
            }
        }

        @Nested
        @DisplayName("1보다 작은 정수가 주어진다면")
        class Context_with_argument_is_less_than_1 {
            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void it_throws_an_exception() {
                int number = 0;
                assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("45보다 큰 정수가 주어진다면")
        class Context_with_argument_is_greater_than_45 {
            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void it_throws_an_exception() {
                int number = 46;
                assertThatThrownBy(() -> LottoNumber.of(number)).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

}
