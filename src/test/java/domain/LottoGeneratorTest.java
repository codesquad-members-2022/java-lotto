package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import domain.Lotto.Lotto;
import domain.Lotto.LottoGenerator;

class LottoGeneratorTest {

    @Test
    @DisplayName("랜덤한 6자리 로또를 생성한다.")
    void make() {
        Lotto lotto = LottoGenerator.generateRandomLotto();
        System.out.println(lotto);
        assertThat(lotto.size()).isEqualTo(6);
    }
}
