package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPaperTest {

    private int purchaseAmount = 14_000;
    private int manualLottoCount = 3;
    private LottoPaper lottoPaper;
    private List<Integer> allNumberStream = IntStream.range(1, 46).boxed().collect(Collectors.toList());

    @BeforeEach
    void setup() {
        Map<Integer, List<Integer>> allNumbers = new HashMap<>();
        allNumbers.put(0, IntStream.range(1, 46).boxed().collect(Collectors.toList()));
        allNumbers.put(1, IntStream.range(1, 46).boxed().collect(Collectors.toList()));
        allNumbers.put(2, IntStream.range(1, 46).boxed().collect(Collectors.toList()));

        LottoStore lottoStore = new LottoStore();
        lottoPaper = lottoStore.purchase(purchaseAmount, manualLottoCount, allNumbers);
    }

    @Test
    @DisplayName("구입 금액을 전달할때 금액에 맞는 로또 갯수를 리턴한다")
    void purchaseTest() {
        // given

        // when

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(purchaseAmount / 1000);
    }
}
