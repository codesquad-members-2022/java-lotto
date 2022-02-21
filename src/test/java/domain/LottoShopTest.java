package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoShopTest {

    LottoShop lottoShop;

    @BeforeEach
    void beforeEach() {
        lottoShop = new LottoShop();
    }

    @Test
    @DisplayName("구입 금액을 입력하면 해당 금액으로 구매할 수 있는 로또 리스트를 반환한다 ")
    void order() {
        int balance = 14000;
        List<Lotto> actual = lottoShop.order(balance);
        assertThat(actual.size()).isEqualTo(14);
    }
}
