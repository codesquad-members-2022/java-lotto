package domain;

import domain.factory.CustomTicketFactory;
import domain.factory.RandomTicketFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TicketFactoryTest {
    private LottoTicketSeller seller;

    @Test
    void 사용자_정의_티켓_반환하는_함수() {
        seller = new LottoTicketSeller(new CustomTicketFactory());
        LottoTicket lottoTicket = seller.exchangeTicket(
                new ArrayList<>(
                        List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        assertThat(lottoTicket.size()).isEqualTo(6);
    }

    @Test
    void 무작위_티켓_반환하는_함수() {
        seller = new LottoTicketSeller(new RandomTicketFactory());
        LottoTicket lottoTicket = seller.exchangeTicket(new ArrayList<>());
        assertThat(lottoTicket.size()).isEqualTo(6);
    }
}
