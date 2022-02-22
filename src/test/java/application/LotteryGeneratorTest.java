package application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryGeneratorTest {

    private LotteryGenerator lotteryGenerator;

    @BeforeEach
    void setUp() {
        lotteryGenerator = new LotteryGenerator();
    }

    @Test
    @DisplayName("유저 로또 생성 테스트")
    void createLottoTest() {
        Lottery lotto = lotteryGenerator.create();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }
}