package application.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import application.domain.Lotto;

class StatisticsTest {

    @Test
    @DisplayName("당첨 갯수 배열을 입력받으면 정확한 수익율을 반환해야 한다.")
    void calculateYield() {
        //given
        int[] counts = {13, 0, 0, 1, 0, 0, 0, 0};
        double tmp = (5000.0 - 14000) / 14000 * 100;
        //then
        double expect = Statistics.calculateYield(counts);
        //when
        assertThat(expect).isEqualTo(tmp);
    }

    @Test
    @DisplayName("로또 리스트의 당첨 통계를 반환해야 한다.")
    void makeStatistics() {
        //given
        int[] counts = {0, 0, 0, 0, 0, 0, 0, 1};
        List<Integer> number = List.of(2, 3, 4, 5, 6, 8);
        Lotto lotto = new Lotto(number);
        List<Lotto> lottos = List.of(lotto);
        List<Integer> winning = List.of(2, 3, 4, 5, 6, 7);
        Lotto winningNumber = new Lotto(winning);

        int bonusBall = 8;
        //when
        int[] expect = Statistics.makeStatistics(lottos, winningNumber, bonusBall);
        //then
        assertThat(expect).isEqualTo(counts);
    }
}
