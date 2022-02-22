package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketSellerTest {

//    @Test
//    void countNumberOfTicketsTest() {
//        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller();
//        int money = 14000;
//        assertThat(lottoTicketSeller.countNumberOfTickets(money)).isEqualTo(14);
//        money = 14500;
//        assertThat(lottoTicketSeller.countNumberOfTickets(money)).isEqualTo(14);
//    }

    @Test
    void exchangeTicketTest() {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller();
        int money = 14000;
        assertThat(lottoTicketSeller.exchangeTicket(money).size()).isEqualTo(14);
    }
}
