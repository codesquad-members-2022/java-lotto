package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class User {
    int purchasedAmount;
    int change;
    List<LottoTicket> tickets;

    public void purchaseTicketsFrom(TicketOffice to) {
        int amount = InputView.getAmount();
        int pricePerTicket = to.getPrice();
        int numberOfTickets = amount / pricePerTicket;

        this.tickets = to.issueTickets(numberOfTickets);
        this.purchasedAmount = pricePerTicket * numberOfTickets;
        this.change = amount - purchasedAmount;

        OutputView.completePurchase(numberOfTickets, change, tickets);
    }
}
