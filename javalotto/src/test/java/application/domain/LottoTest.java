package application.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 6개가 아닐 경우 예외가 발생해야 한다.")
    void createLottoTest() {
        //given
        List<Integer> number = List.of(2, 3, 4, 5, 6, 7, 8);
        //when
        //then
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 6개만 가능합니다.");
    }

    @Test
    @DisplayName("로또 번호에 중복이 있을 경우 예외가 발생해야 한다.")
    void createLottoTest2() {
        //given
        List<Integer> number = List.of(2, 3, 4, 5, 7, 7);
        //when
        //then
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(number);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호들은 중복될 수 없습니다.");

    }

    @Test
    @DisplayName("로또 번호에 보너스 볼과 동일한 숫자가 있으면 true를 반환해야 한다.")
    void isContainBonusBallNumber() {
        //given
        int bonusBall = 7;
        List<Integer> number = List.of(2, 3, 4, 5, 6, 7);
        Lotto lotto = new Lotto(number);
        //when
        boolean isContain = lotto.isContainBonusBallNumber(bonusBall);
        //then
        assertThat(isContain).isTrue();
    }

    @Test
    @DisplayName("당첨 번호와 일치하는 번호의 개수를 반환해야 한다.")
    void getTheNumberOfMatches() {
        //given
        List<Integer> number = List.of(2, 3, 4, 5, 6, 7);
        List<Integer> winningNumber = List.of(2, 3, 4, 5, 6, 7);
        Lotto lotto = new Lotto(number);
        Lotto winningLotto = new Lotto(winningNumber);
        //when
        int count = lotto.getTheNumberOfMatches(winningLotto);
        //then
        assertThat(count).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 번호를 ,와 공백으로 구분해서 문자열로 반환해야 한다.")
    void lottoNumbersToString() {
        //given
        List<Integer> number = List.of(2, 3, 4, 5, 6, 7);
        Lotto lotto = new Lotto(number);
        String tmp = "2, 3, 4, 5, 6, 7";
        //when
        String expect = lotto.lottoNumbersToString();
        //then
        assertThat(expect).isEqualTo(tmp);
    }

}
