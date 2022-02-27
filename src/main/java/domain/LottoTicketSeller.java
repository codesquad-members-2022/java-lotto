package domain;

import domain.factory.TicketFactory;

import java.util.List;

public class LottoTicketSeller {
    private final TicketFactory ticketFactory;

    public LottoTicketSeller(TicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;
    }

    public LottoTicket exchangeTicket(List<LottoNumber> numbers) {
        return ticketFactory.generateTicket(numbers);
    }
}
