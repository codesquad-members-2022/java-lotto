package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("6000원이 주어졌을 때 랜덤한 로또 티켓 6개를 생성한다.")
    void createRandomLottoTicket() {
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(new Money(6000));

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(6);
    }

}
