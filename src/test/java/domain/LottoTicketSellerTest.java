package domain;

import domain.factory.RandomTicketFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTicketSellerTest {
    @Test
    void exchangeTicketTest() {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new RandomTicketFactory());
        assertThat(lottoTicketSeller.exchangeTicket(new ArrayList<LottoNumber>()).size()).isEqualTo(6);
    }
}
