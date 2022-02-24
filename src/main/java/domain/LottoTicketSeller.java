package domain;

import domain.factory.TicketFactory;

import java.util.ArrayList;

public class LottoTicketSeller {
    private TicketFactory ticketFactory;

    public LottoTicketSeller(TicketFactory ticketFactory) {
        this.ticketFactory = ticketFactory;
    }

    public LottoTicket exchangeTicket(ArrayList<LottoNumber> numbers) {
        return ticketFactory.generateTicket(numbers);
    }

    public void setFactory(TicketFactory randomTicketFactory) {
        this.ticketFactory = randomTicketFactory;
    }
}
