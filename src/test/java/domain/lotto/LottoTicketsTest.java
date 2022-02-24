package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("LottoTicketsTest 클래스")
class LottoTicketsTest {

    @Nested
    @DisplayName("createRandomLottoTicket 메서드는")
    class Describe_createRandomLottoTicket {
        @Nested
        @DisplayName("만약 정수3이 주어전다면")
        class Context_with_int_3 {
            @Test
            @DisplayName("3개의 랜덤한 LottoTicket을 가진 LottoTickets를 반환한다.")
            void it_returns_LottoTickets_of_3_LottoTicket() {
                int count = 6;

                LottoTickets sut = LottoTickets.createRandomTickets(count);

                assertThat(sut.getLottoTickets().size()).isEqualTo(6);
            }
        }

        @Nested
        @DisplayName("만약 음수가 주어전다면")
        class Context_with_int_negative {
            @Test
            @DisplayName("IllegalArgumentException 예외를 던진다.")
            void it_throws_exception() {
                int count = -1;

                assertThatThrownBy(() -> LottoTickets.createRandomTickets(count))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("createManualLottoTicket 메서드는")
    class Describe_createManualLottoTicket {
        @Nested
        @DisplayName("만약 정상적인 List<LottoTicket> 형태의 로또 티켓 두개를 넣는다면")
        class Context_with_normal_manual_lottotickets {
            private List<LottoTicket> initLottoTickets() {
                Set<LottoNumber> lottoNumbers1 = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        .collect(Collectors.toSet());

                Set<LottoNumber> lottoNumbers2 = Stream.of(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(13),
                                LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))
                        .collect(Collectors.toSet());

                List<LottoTicket> tickets = new ArrayList<>();
                tickets.add(LottoTicket.createManualTicket(lottoNumbers1));
                tickets.add(LottoTicket.createManualTicket(lottoNumbers2));
                return tickets;
            }

            @Test
            @DisplayName("지정한 2개의 LottoTicket을 가진 LottoTickets를 반환한다.")
            void it_returns_normal_lottoticket() {
                List<LottoTicket> tickets = initLottoTickets();

                LottoTickets sut = LottoTickets.createManualTickets(tickets);

                assertThat(sut.toString()).hasToString("[1, 2, 3, 4, 5, 6]\n[11, 12, 13, 14, 15, 16]");
            }
        }

    }

    @Nested
    @DisplayName("merge 메서드는")
    class Describe_merge {
        @Nested
        @DisplayName("만약 2개의 로또 티켓을 가지고 있는 LottoTickets를 2개 넣는다면")
        class Context_with_merge_lottotickets {
            private LottoTickets initLottoTickets() {
                Set<LottoNumber> lottoNumbers1 = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        .collect(Collectors.toSet());

                Set<LottoNumber> lottoNumbers2 = Stream.of(LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(13),
                                LottoNumber.of(14), LottoNumber.of(15), LottoNumber.of(16))
                        .collect(Collectors.toSet());

                List<LottoTicket> tickets = new ArrayList<>();
                tickets.add(LottoTicket.createManualTicket(lottoNumbers1));
                tickets.add(LottoTicket.createManualTicket(lottoNumbers2));

                return LottoTickets.createManualTickets(tickets);
            }

            @Test
            @DisplayName("합쳐진 4개의 LottoTicket을 가진 LottoTickets를 반환한다.")
            void it_returns_normal_lottoticket() {
                LottoTickets tickets = initLottoTickets();
                LottoTickets tickets2 = initLottoTickets();

                LottoTickets sut = LottoTickets.merge(tickets, tickets2);

                assertThat(sut.toString()).hasToString("[1, 2, 3, 4, 5, 6]\n[11, 12, 13, 14, 15, 16]\n" +
                        "[1, 2, 3, 4, 5, 6]\n[11, 12, 13, 14, 15, 16]");
            }
        }
    }

}
