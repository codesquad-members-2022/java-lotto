package application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("유저 로또 생성 테스트")
    void createLottoTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = lottoGenerator.create();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}