package domain;

import domain.factory.CustomTicketFactory;
import domain.factory.RandomTicketFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PersonTest {

    @Test
    void matchingNumberTest() {
        // given
        Person person = new Person();
        LottoTicketSeller seller = new LottoTicketSeller(new CustomTicketFactory());

        String[] winningNumbers = new String[]{"1", "2", "3", "4", "5", "6"};

        int[] numbers2 = new int[]{1, 2, 3, 4, 5, 7};
        ArrayList<LottoNumber> lottoNumbers2 = Arrays.stream(numbers2)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toCollection(ArrayList::new));

        int[] numbers3 = new int[]{1, 2, 3, 4, 9, 8};
        ArrayList<LottoNumber> lottoNumbers3 = Arrays.stream(numbers3)
                .mapToObj(i -> new LottoNumber(i))
                .collect(Collectors.toCollection(ArrayList::new));

        // when
        person.buyCustomLottoTicket(seller.exchangeTicket(lottoNumbers2));
        person.buyCustomLottoTicket(seller.exchangeTicket(lottoNumbers3));

        // then
        assertThat(person.checkLottoTickets(new WinningNumbers(winningNumbers, "45"))).isEqualTo(new int[]{0, 0, 0, 0, 1, 1, 0, 0});
    }
}
