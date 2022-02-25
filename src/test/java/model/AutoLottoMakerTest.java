package model;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AutoLottoMakerTest {

    AutoLottoMaker autoLottoMaker;

    @BeforeEach
    void init() {
        autoLottoMaker = new AutoLottoMaker();
    }

    @Test
    void test() {
        List<Integer> lotto = autoLottoMaker.createLotto();
        Assertions.assertThat(lotto.size()).isEqualTo(6);
    }


}
