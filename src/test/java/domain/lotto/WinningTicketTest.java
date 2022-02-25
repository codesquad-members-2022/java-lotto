package domain.lotto;

import org.junit.jupiter.api.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("WinningTicket 클래스")
class WinningTicketTest {

    @Nested
    @DisplayName("생성자는")
    class Describe_constructor {

        @Nested
        @DisplayName("만약 당첨번호와 보너스번호가 겹친다면")
        class Context_with_Duplicate_WinningNumbers_and_BonusNumber {

            LottoTicket winningLottoTicket;

            @BeforeEach
            void setUpWinningNumber() {
                this.winningLottoTicket = LottoTicket.createManualTicket(IntStream.rangeClosed(1, 6).mapToObj(LottoNumber::of).collect(Collectors.toSet()));
            }

            @Test
            @DisplayName("IllegalArgumentException을 던진다.")
            void it_throws_exception() {
                LottoNumber bonusNumber = LottoNumber.of(6);
                assertThatThrownBy(() -> new WinningTicket(winningLottoTicket, bonusNumber))
                        .isInstanceOf(IllegalArgumentException.class);
            }
        }

    }

    @Nested
    @DisplayName("match 메서드는")
    class Describe_match {

        private WinningTicket winningTicket;

        @BeforeEach
        void setUpWinningNumber() {
            Set<LottoNumber> winningNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                            LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                    .collect(Collectors.toSet());
            LottoTicket winningLottoTicket = LottoTicket.createManualTicket(winningNumbers);
            LottoNumber bonusNumber = LottoNumber.of(7);
            winningTicket = new WinningTicket(winningLottoTicket, bonusNumber);
        }

        @Nested
        @DisplayName("만약 로또티켓의 6개의 번호가 일치하면")
        class Context_with_Six_Number_Match {

            @Test
            @DisplayName("1등 Rank를 반환한다.")
            void it_returns_First_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FIRST);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 5개의 번호가 일치하고, 보너스넘버도 일치하면")
        class Context_with_Five_Number_Match_and_Match_Bonus {

            @Test
            @DisplayName("2등 Rank를 반환한다.")
            void it_returns_Second_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(7))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.SECOND);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 5개의 번호가 일치하고, 보너스넘버가 일치하지 않으면")
        class Context_with_Five_Number_Match_and_No_Match_Bonus {

            @Test
            @DisplayName("3등 Rank를 반환한다.")
            void it_returns_Third_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(8))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.THIRD);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 4개의 번호가 일치한다면")
        class Context_with_Four_Number_Match {

            @Test
            @DisplayName("4등 Rank를 반환한다.")
            void it_returns_Fourth_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(4), LottoNumber.of(8), LottoNumber.of(9))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FOURTH);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 3개의 번호가 일치한다면")
        class Context_with_Three_Number_Match {

            @Test
            @DisplayName("5등 Rank를 반환한다.")
            void it_returns_Fifth_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3),
                                LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FIFTH);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 2개의 번호가 일치한다면")
        class Context_with_Two_Number_Match {

            @Test
            @DisplayName("Failed Rank를 반환한다.")
            void it_returns_Failed_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(8),
                                LottoNumber.of(9), LottoNumber.of(10), LottoNumber.of(11))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FAILED);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 1개의 번호가 일치한다면")
        class Context_with_One_Number_Match {

            @Test
            @DisplayName("Failed Rank를 반환한다.")
            void it_returns_Failed_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(1), LottoNumber.of(8), LottoNumber.of(9),
                                LottoNumber.of(10), LottoNumber.of(11), LottoNumber.of(12))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FAILED);
            }
        }

        @Nested
        @DisplayName("만약 로또티켓의 0개의 번호가 일치한다면")
        class Context_with_No_Number_Match {

            @Test
            @DisplayName("Failed Rank를 반환한다.")
            void it_returns_Failed_Rank() {
                Set<LottoNumber> lottoNumbers = Stream.of(LottoNumber.of(8), LottoNumber.of(9), LottoNumber.of(10),
                                LottoNumber.of(11), LottoNumber.of(12), LottoNumber.of(13))
                        .collect(Collectors.toSet());

                LottoTicket lottoTicket = LottoTicket.createManualTicket(lottoNumbers);
                Rank matchRank = winningTicket.match(lottoTicket);
                assertThat(matchRank).isSameAs(Rank.FAILED);
            }
        }

    }

}
