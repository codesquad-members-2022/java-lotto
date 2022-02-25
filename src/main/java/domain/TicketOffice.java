package domain;

import view.InputView;

import java.util.*;

public abstract class TicketOffice {
    private final static int PRICE = 1000;

    public abstract List<LottoTicket> issueTickets(int numberOfTickets);

    public static int getPrice() {
        return PRICE;
    }
}
