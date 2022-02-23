package domain;

import static org.assertj.core.api.Assertions.*;

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
        MyLotteries myLotteries = lottoShop.order(balance);
        assertThat(myLotteries.count()).isEqualTo(14);
    }

    // @Test
    // @DisplayName("구매한 로또 목록과 당첨 번호를 입력하면 일치 개수를 계산해서 반환한다.")
    // void getResult() {
    //     List<Lotto> purchasedLotteries = new ArrayList<>();
    //
    //     purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 45, 44, 43)));
    //     purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 45, 44)));
    //     purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 45)));
    //     purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 7)));
    //     purchasedLotteries.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    //
    //     WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6),
    //         7);
    //
    //     Map<Rank, Integer> result = lottoShop.getResult(purchasedLotteries, winningNumbers);
    //     assertThat(result.get(Rank.rank1)).isEqualTo(1);
    //     assertThat(result.get(Rank.rank2)).isEqualTo(1);
    //     assertThat(result.get(Rank.rank3)).isEqualTo(1);
    //     assertThat(result.get(Rank.rank4)).isEqualTo(1);
    //     assertThat(result.get(Rank.rank5)).isEqualTo(1);
    // }
}
