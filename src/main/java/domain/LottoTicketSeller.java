package domain;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LottoTicketSeller {
    private static final int TICKET_PRICE = 1000;

    public ArrayList<LottoTicket> exchangeTicket(int money) {
        ArrayList<LottoTicket> resultTickets = new ArrayList<>();
        IntStream.range(0, countNumberOfTickets(money))
                .forEach(i -> resultTickets.add(LottoTicketFactory.generateRandomTicket()));
        return resultTickets;
    }

    private int countNumberOfTickets(int money) {
        return money / TICKET_PRICE;
    }
}
