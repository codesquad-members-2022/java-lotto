package domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("6000원이 주어졌을 때 랜덤한 로또 티켓 6개를 생성한다.")
    void createRandomLottoTicket() {
        LottoTickets lottoTickets = LottoTickets.createRandomTickets(6);

        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("수동 로또 티켓 리스트로 LottoTickets 생성")
    void createManualLottoTicket() {
        List<LottoTicket> tickets = new ArrayList<>();
        tickets.add(LottoTicket.createRandomTicket());
        tickets.add(LottoTicket.createRandomTicket());
        tickets.add(LottoTicket.createRandomTicket());

        LottoTickets manualLottoTickets = LottoTickets.createManualTickets(tickets);

        assertThat(manualLottoTickets.getLottoTickets().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("수동+자동 티켓 합쳐 LottoTickets 생성")
    void mergeLottoTicket() {
        LottoTickets lottoTickets1 = LottoTickets.createRandomTickets(5);
        LottoTickets lottoTickets2 = LottoTickets.createRandomTickets(5);

        LottoTickets mergeLottoTickets = LottoTickets.merge(lottoTickets1, lottoTickets2);

        assertThat(mergeLottoTickets.getLottoTickets().size()).isEqualTo(10);
    }
}
