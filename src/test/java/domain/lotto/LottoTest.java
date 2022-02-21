package domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void createLotto() {
        Lotto lotto = Lotto.create();

        assertThat(lotto.getLottoNumbers().getLottoNumbersSize()).isEqualTo(6);
    }
}
