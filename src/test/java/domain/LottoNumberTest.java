package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void createTest() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @Test
    void numberValidationTest() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalArgumentException.class);

        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
        assertThat(new LottoNumber(45)).isEqualTo(new LottoNumber(45));

        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalArgumentException.class);
    }
}
