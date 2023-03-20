package controller;

import static org.assertj.core.api.Assertions.*;

import domain.LottoSheet;
import domain.ManualLottoSheet;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    @DisplayName("정상적인 로또 번호를 입력하면, 예외 발생 없이 로또 번호를 반환합니다.")
    void 정상적_로또번호_입력_테스트() {
        // given
        LottoSheet lottoSheet = new LottoSheet(Arrays.asList(1, 2, 3, 4, 5, 6));
        List<LottoSheet> lottoTicket = Arrays.asList(lottoSheet);

        // when
        ManualLottoSheet manualLottoSheet = new ManualLottoSheet(lottoTicket);

        // then
        assertThat(manualLottoSheet.getManualNumbers()).isEqualTo(lottoTicket);
    }

    @Test
    @DisplayName("중복된 로또 번호를 입력하면, 예외가 발생해야한다.")
    void 중복_로또번호_입력_테스트() {
        // given
        LottoSheet lottoSheet = new LottoSheet(Arrays.asList(1, 2, 3, 4, 5, 1));
        List<LottoSheet> lottoTicket = Arrays.asList(lottoSheet);

        // when

        // then
        assertThatThrownBy(() -> new ManualLottoSheet(lottoTicket))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복된 당첨번호는 입력할 수 없습니다!!");
    }

    @Test
    @DisplayName("7개 이상의 로또 번호를 입력하면, 예외가 발생해야한다.")
    void 일곱개_이상의_로또번호_입력_테스트() {
        // given
        LottoSheet lottoSheet = new LottoSheet(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<LottoSheet> lottoTicket = Arrays.asList(lottoSheet);

        // when

        // then
        assertThatThrownBy(() -> new ManualLottoSheet(lottoTicket))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("적절한 당첨 번호 개수가 아닙니다!!");
    }
}
