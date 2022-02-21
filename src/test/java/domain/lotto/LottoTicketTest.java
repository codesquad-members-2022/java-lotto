package domain.lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    @Test
    void createLotto() {
        LottoTicket lottoTicket = LottoTicket.createRandomTicket();

        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(6);
    }
}
