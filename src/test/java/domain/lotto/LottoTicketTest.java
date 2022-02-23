package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoTicket 클래스")
class LottoTicketTest {

    @Nested
    @DisplayName("createRandomTicket 메소드는")
    class Describe_createRandomTicket {

        @Nested
        @DisplayName("만약 매개변수 없이 호출한다면")
        class Context_without_parameter {
            @Test
            @DisplayName("6개의 랜덤 번호를 가진 로또 티켓(LottoTicket)을 리턴한다")
            void it_return_a_Random_LottoTicket() {
                LottoTicket lottoTicket = LottoTicket.createRandomTicket();

                assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
            }
        }
    }

    @Nested
    @DisplayName("createManualTicket 메소드는")
    class Describe_createManualTicket {
        @Nested
        @DisplayName("만약 서로 다른 6개의 LottoNumbers가 주어진다면")
        class Context_with_LottoNumbers {
            @Test
            @DisplayName("6개의 번호를 가진 로또 티켓(LottoTicket)을 리턴한다")
            void it_return_a_Manual_LottoTicket() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);

                assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
            }
        }

        @Nested
        @DisplayName("만약 6개보다 적은 LottoNumbers가 주어진다면")
        class Context_with_LottoNumbers_Size_is_less_than_6 {
            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void it_throw_a_exception() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5))
                        .collect(Collectors.toSet());

                assertThatThrownBy(() -> LottoTicket.createManualTicket(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
            }
        }

        @Nested
        @DisplayName("만약 6개보다 많은 LottoNumbers가 주어진다면")
        class Context_with_LottoNumbers_Size_is_greater_than_6 {
            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void it_throw_a_exception() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7))
                        .collect(Collectors.toSet());

                assertThatThrownBy(() -> LottoTicket.createManualTicket(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
            }
        }
    }
}
