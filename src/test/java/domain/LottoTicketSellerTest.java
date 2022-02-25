package domain;

import domain.factory.CustomTicketFactory;
import domain.factory.RandomTicketFactory;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottoTicketSellerTest {
    @Test
    void exchangeTicketTest() {
        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new RandomTicketFactory());
        assertThat(lottoTicketSeller.exchangeTicket(new ArrayList<LottoNumber>()).size()).isEqualTo(6);
    }

    @Test
    void customTicketTest() {
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        ArrayList<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toCollection(ArrayList::new));

        LottoTicketSeller lottoTicketSeller = new LottoTicketSeller(new CustomTicketFactory());
        assertThat(lottoTicketSeller.exchangeTicket(lottoNumbers)).isEqualTo(new LottoTicket(lottoNumbers));
    }
}
