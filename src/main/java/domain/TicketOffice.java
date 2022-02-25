package domain;

import view.InputView;

import java.util.*;

public abstract class TicketOffice {
    private final int PRICE = 1000;

    public abstract List<LottoTicket> issueTickets(int numberOfTickets);


    public int getPrice() {
        return this.PRICE;
    }
}
