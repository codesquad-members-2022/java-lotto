package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonTest {

    @Test
    void createTest() {
        Person person = new Person("jerry", 14000, new LottoTicketSeller());

        assertThat(person).isEqualTo(new Person("jerry", 14000, new LottoTicketSeller()));
        assertThat(person).isEqualTo(new Person("jerry", 1000, new LottoTicketSeller()));
    }

    @Test
    void buyRandomTest() {
        // given
        Person person = new Person("jerry", 14000, new LottoTicketSeller());
        Person person2 = new Person("terry", 10000, new LottoTicketSeller());

        //when
        person.buyRandomLottoTicket(10000);
        person2.buyRandomLottoTicket(4500);

        // then
        assertThat(person.getBoughtTicketNumber()).isEqualTo(10);
        assertThat(person.getRestMoney()).isEqualTo(4000);

        assertThat(person2.getBoughtTicketNumber()).isEqualTo(4);
        assertThat(person2.getRestMoney()).isEqualTo(5500);
    }

    @Test
    void buyCustomTest() {
        // given
        Person person = new Person("jerry", 14000, new LottoTicketSeller());

        // when
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        person.buyCustomLottoTicket(numbers);

        //then
        assertThat(person.getBoughtTicketNumber()).isEqualTo(1);
        assertThat(person.getRestMoney()).isEqualTo(13000);
    }

    @Test
    void matchingNumberTest() {
        // given
        Person person = new Person("jerry", 14000, new LottoTicketSeller());

        // when
        int[] numbers = new int[]{1, 2, 3, 4, 5, 6};
        person.buyCustomLottoTicket(numbers);
        int[] numbers2 = new int[]{1, 2, 3, 4, 5, 7};
        person.buyCustomLottoTicket(numbers2);
        int[] numbers3 = new int[]{1, 2, 3, 4, 9, 8};
        person.buyCustomLottoTicket(numbers3);

        // then
        assertThat(person.checkLottoTickets(numbers)).isEqualTo(new int[]{0, 0, 0, 0, 1, 1, 1});

    }

    @Test
    void buyFailTest() {
        Person person = new Person("jerry", 14000, new LottoTicketSeller());
        assertThatThrownBy(() -> person.buyRandomLottoTicket(14001)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> person.buyRandomLottoTicket(-1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> person.buyRandomLottoTicket(999)).isInstanceOf(IllegalArgumentException.class);
    }
}
