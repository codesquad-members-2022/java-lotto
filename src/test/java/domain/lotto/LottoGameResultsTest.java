package domain.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoGameResults 클래스")
class LottoGameResultsTest {

    @Nested
    @DisplayName("getReturnToInvestment 메서드는")
    class Describe_getReturnToInvestment {

        private WinningTicket winningTicket;

        @BeforeEach
        void setUpWinningTicket() {
            Set<LottoNumber> winningNumbers = IntStream.rangeClosed(1,6).mapToObj(LottoNumber::of).collect(Collectors.toSet());
            LottoTicket winningLottoTicket = LottoTicket.createManualTicket(winningNumbers);
            LottoNumber bonusNumber = LottoNumber.of(7);
            this.winningTicket = new WinningTicket(winningLottoTicket, bonusNumber);
        }

        @Nested
        @DisplayName("만약 1개의 로또를 구입하고 1등인 경우라면")
        class Context_with_lottoTicket_is_First_rank {
            @Test
            @DisplayName("수익률 199999900.%를 리턴한다.")
            void it_returns_199999900_returnToInvestment() {
                Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1,6).mapToObj(LottoNumber::of).collect(Collectors.toSet());
                LottoTickets lottoTickets = LottoTickets.createManualTickets(List.of(LottoTicket.createManualTicket(lottoNumbers)));
                LottoGameResults sut = new LottoGameResults(lottoTickets, winningTicket);

                double result = sut.getReturnToInvestment();

                assertThat(result).isEqualTo(199999900.);
            }
        }

        @Nested
        @DisplayName("만약 1개의 로또를 구입하고 꽝인 경우라면")
        class Context_with_lottoTicket_is_Failed_rank {
            @Test
            @DisplayName("수익률 -100%를 리턴한다.")
            void it_returns_negative_100_returnToInvestment() {
                Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(7,12).mapToObj(LottoNumber::of).collect(Collectors.toSet());
                LottoTickets lottoTickets = LottoTickets.createManualTickets(List.of(LottoTicket.createManualTicket(lottoNumbers)));
                LottoGameResults sut = new LottoGameResults(lottoTickets, winningTicket);

                double result = sut.getReturnToInvestment();

                assertThat(result).isEqualTo(-100.);
            }
        }

        @Nested
        @DisplayName("만약 3개의 로또를 구입하고 5등이 1개인 경우라면")
        class Context_with_Three_LottoTickets_buy_and_one_FIFTH_Rank {
            @Test
            @DisplayName("수익률 66.66666666666666% 리턴한다.")
            void it_returns_66_returnToInvestment() {
                Set<LottoNumber> lottoNumbers1 = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(7), LottoNumber.of(8), LottoNumber.of(9)).collect(Collectors.toSet());
                Set<LottoNumber> lottoNumbers2 = IntStream.rangeClosed(7,12).mapToObj(LottoNumber::of).collect(Collectors.toSet());
                Set<LottoNumber> lottoNumbers3 = IntStream.rangeClosed(7,12).mapToObj(LottoNumber::of).collect(Collectors.toSet());
                LottoTicket manualTicket1 = LottoTicket.createManualTicket(lottoNumbers1);
                LottoTicket manualTicket2 = LottoTicket.createManualTicket(lottoNumbers2);
                LottoTicket manualTicket3 = LottoTicket.createManualTicket(lottoNumbers3);
                LottoTickets lottoTickets = LottoTickets.createManualTickets(List.of(manualTicket1, manualTicket2, manualTicket3));
                LottoGameResults sut = new LottoGameResults(lottoTickets, winningTicket);

                double result = sut.getReturnToInvestment();

                assertThat(result).isEqualTo(66.66666666666666);
            }
        }

    }


}
