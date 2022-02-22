package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @DisplayName("구입 금액을 입력하면 해당 금액으로 구매할 수 있는 로또 리스트를 반환한다.")
    void order() {
        int balance = 14000;
        List<Lotto> actual = lottoShop.order(balance);
        assertThat(actual.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("구매한 로또 목록과 당첨 번호를 입력하면 일치 개수를 계산해서 반환한다.")
    void getResult() {
        List<Lotto> purchasedLotteries = new ArrayList<>();

        purchasedLotteries.add(new Lotto(List.of(8, 21, 23, 41, 42, 43)));
        purchasedLotteries.add(new Lotto(List.of(3, 5, 11, 16, 32, 38)));
        purchasedLotteries.add(new Lotto(List.of(7, 11, 16, 35, 36, 44)));
        purchasedLotteries.add(new Lotto(List.of(1, 8, 11, 31, 41, 42)));
        purchasedLotteries.add(new Lotto(List.of(13, 14, 16, 38, 42, 45)));
        purchasedLotteries.add(new Lotto(List.of(7, 11, 30, 40, 42, 43)));
        purchasedLotteries.add(new Lotto(List.of(2, 13, 22, 32, 38, 45)));
        purchasedLotteries.add(new Lotto(List.of(23, 25, 33, 36, 39, 41)));
        purchasedLotteries.add(new Lotto(List.of(1, 3, 5, 14, 22, 45)));
        purchasedLotteries.add(new Lotto(List.of(5, 9, 38, 41, 43, 44)));
        purchasedLotteries.add(new Lotto(List.of(2, 8, 9, 18, 19, 21)));
        purchasedLotteries.add(new Lotto(List.of(13, 14, 18, 21, 23, 35)));
        purchasedLotteries.add(new Lotto(List.of(17, 21, 29, 37, 42, 45)));
        purchasedLotteries.add(new Lotto(List.of(3, 8, 27, 30, 35, 44)));

        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));

        Map<Rank, Integer> result = lottoShop.getResult(purchasedLotteries, winningNumbers);
        assertThat(result.get(Rank.rank2)).isEqualTo(0);
        assertThat(result.get(Rank.rank1)).isEqualTo(0);
        assertThat(result.get(Rank.rank3)).isEqualTo(0);
        assertThat(result.get(Rank.rank4)).isEqualTo(1);
    }
}
