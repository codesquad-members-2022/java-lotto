package controller;

import static org.assertj.core.api.Assertions.*;

import domain.LottoGenerator;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class LottoGameTest {

    @BeforeEach
    void setLottoGame() {
    }

    @RepeatedTest(10)
    @DisplayName("랜덤으로 로또 번호를 생성했을때, 번호의 개수는 6개이여야 한다.")
    void randomLottoNumberSizeTest() {
        // given
        List<Integer> randomLottoNumbers = LottoGenerator.getShuffledNumbers();

        // when
        int standardLottoSize = 6;

        // then
        assertThat(randomLottoNumbers.size()).isEqualTo(standardLottoSize);
    }

    @RepeatedTest(10)
    @DisplayName("랜덤으로 로또 번호를 생성했을때, 번호는 1보다 크고 46보다 작은 자연수여야 한다.")
    void randomLottoNumberBiggerThanZeroTest() {
        // given
        List<Integer> randomLottoNumbers = LottoGenerator.getShuffledNumbers();

        // when
        int minLottoNumber = 1;
        int maxLottoNumber = 45;

        // then
        for (int lottoNumber : randomLottoNumbers) {
            assertThat(lottoNumber).isBetween(minLottoNumber,maxLottoNumber);
        }
    }
}
