package domain;

import view.InputView;
import view.OutputView;

import java.util.List;

public class User {
    private int purchasedAmount;
    private int change;
    private int amount;
    private List<LottoTicket> tickets;

    public void purchaseTicketsFrom(TicketOffice to) {
        this.amount = InputView.getAmount();
        int pricePerTicket = to.getPrice();
        int numberOfTickets = this.amount / pricePerTicket;

        this.tickets = to.issueTickets(numberOfTickets);
        this.purchasedAmount = pricePerTicket * numberOfTickets;
        this.change = this.amount - purchasedAmount;

        OutputView.completePurchase(numberOfTickets, change, tickets);
    }

    public void checkMyTicketsFrom(LottoCompany lottoCompany){
        lottoCompany.check(this.tickets);
    }
}
