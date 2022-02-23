package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketSellerTest {
    @Test
    void exchangeTicketTest() {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller();
        int money = 14000;
        assertThat(lottoTicketSeller.exchangeTicket(money).size()).isEqualTo(14);
    }
}
