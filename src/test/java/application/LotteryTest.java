package application;

import static org.assertj.core.api.Assertions.assertThat;

import application.domain.*;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LotteryTest {

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
        UserLotteries userLottery = new UserLotteries(1,14);
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
    void matchingTest(List<Integer> numbers, Result result) {

        UserLotteries userLotteries = new UserLotteries(numbers);
        userLotteries.addUserLottery(numbers);

        WinningLottery winningLottery = new WinningLottery(List.of(1, 2, 3, 4, 5, 6), 7);
        userLotteries.compareEach(winningLottery);

        List<UserLottery> lotteries = userLotteries.get();
        assertThat(lotteries.get(0).getResult()).isEqualTo(result);
    }

    private static Stream<Arguments> provideParameters() {
        return Stream.of(
            Arguments.of(List.of(1, 2, 3, 4, 5, 6), Prize.FIRST.getResult()),
            Arguments.of(List.of(2, 3, 4, 5, 6, 7), Prize.SECOND.getResult()),
            Arguments.of(List.of(2, 3, 4, 5, 6, 8), Prize.THIRD.getResult()),
            Arguments.of(List.of(3, 4, 5, 6, 7, 8), Prize.FORTH.getResult()),
            Arguments.of(List.of(4, 5, 6, 7, 8, 9), Prize.FIFTH.getResult())
        );
    }

}