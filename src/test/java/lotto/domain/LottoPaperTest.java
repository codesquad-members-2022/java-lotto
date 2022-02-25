package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPaperTest {

    private int purchaseAmount = 500_000;
    private LottoPaper lottoPaper;

    @BeforeEach
    void setup() {
        LottoStore lottoStore = new LottoStore();
        lottoPaper = lottoStore.purchase(purchaseAmount);
    }

    @Test
    @DisplayName("구입 금액을 전달할때 금액에 맞는 로또 갯수를 리턴한다")
    void purchaseTest() {
        // given

        // when

        // then
        assertThat(lottoPaper.getLottoSize()).isEqualTo(purchaseAmount / 1000);
    }

    @Test
    @DisplayName("당첨번호를 전달하면 각 로또가 몇 개 당첨되었는지 리스트로 리턴한다")
    void judgeWinningTest() {
        // given
        String winningString = lottoPaper.showLottoPaper().split(System.lineSeparator())[0];
        String[] splitNumbers = winningString.replaceAll(" ", "")
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .split(",");
        List<Integer> winningNumbers = Arrays.stream(splitNumbers)
                .mapToInt(number -> Integer.parseInt(number))
                .boxed()
                .collect(Collectors.toList());

        // when
        List<Integer> correctNumberCounts = lottoPaper.judgeWinning(winningNumbers);

        // then
        assertThat(correctNumberCounts.contains(6)).isEqualTo(true);
    }
}
