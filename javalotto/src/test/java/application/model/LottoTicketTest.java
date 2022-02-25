package application.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import application.domain.Lotto;

class LottoTicketTest {

    @Test
    @DisplayName("입력 개수에 맞는 로또 개수를 담은 리스트를 반환한다.")
    void makeAutoLottoTest() {
        //given
        int userPurchaseQuantity = 14;
        //when
        List<Lotto> lottos = LottoTicket.makeAutoLotto(userPurchaseQuantity);
        //then
        assertThat(lottos.size()).isEqualTo(userPurchaseQuantity);
    }
}
