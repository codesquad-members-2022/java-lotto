package application;

import static org.assertj.core.api.Assertions.assertThat;

import application.domain.Lottery;
import application.domain.UserLotteries;
import application.domain.WinningLottery;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LotteryGeneratorTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("유저 로또 생성 테스트")
    void createLottoTest() {
        Lottery lotto = new Lottery();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("유저 로또 개수 입력 받아 랜덤으로 생성한다.")
    void userLotteryCountTest() {
        UserLotteries userLottery = new UserLotteries(14);
        assertThat(userLottery.get().size()).isEqualTo(14);
    }

    @Test
    @DisplayName("당첨 로또 번호를 입력 받아 생성한다.")
    void winLotterySelectTest() {
        WinningLottery winningLottery = new WinningLottery(List.of(1, 2, 3, 4, 5, 6), 7);
        assertThat(winningLottery.getNumbers())
            .containsExactly(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호를 비교해서 매칭되는 개수를 증가시킨다.")
    @MethodSource("provideParameters")
    void matchingTest(List<Integer> numbers, int matchCount) {

        UserLotteries userLottery = new UserLotteries(numbers);
        userLottery.addUserLottery(numbers);
        WinningLottery winningLottery = new WinningLottery(List.of(1, 2, 3, 4, 5, 6), 7);
        userLottery.compareEach(winningLottery);

        assertThat(userLottery.getMatchCounts())
            .isEqualTo(List.of(matchCount));
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(List.of(2, 3, 4, 5, 6, 7), 5),
            Arguments.of(List.of(3, 4, 5, 6, 7, 8), 4),
            Arguments.of(List.of(4, 5, 6, 7, 8, 9), 3),
            Arguments.of(List.of(5, 6, 7, 8, 9, 10), 2),
            Arguments.of(List.of(6, 7, 8, 9, 10, 11), 1)
        );
    }

}