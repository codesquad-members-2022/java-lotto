package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int purchasedAmount;
    private int change;
    private int amount;
    private int totalNumberOfTickets;
    private List<LottoTicket> tickets = new ArrayList<>();

    public void goTicketOffice(){
        this.amount = InputView.getAmount();
        int pricePerTicket = TicketOffice.getPrice();
        int numberOfManualTicket = InputView.getNumberOfManualTicket();
        int numberOfAutoTicket = (this.amount / pricePerTicket) - numberOfManualTicket;
        this.totalNumberOfTickets = numberOfAutoTicket + numberOfManualTicket;

        purchaseTicketsFrom(new ManualTicketOffice(), numberOfManualTicket);
        purchaseTicketsFrom(new AutoTicketOffice(), numberOfAutoTicket);

        this.purchasedAmount = pricePerTicket * totalNumberOfTickets;
        this.change += this.amount - purchasedAmount;
        OutputView.printPurchase(totalNumberOfTickets, change, tickets);

    }

    private void purchaseTicketsFrom(TicketOffice to, int numberOfTickets) {
        this.tickets.addAll(to.issueTickets(numberOfTickets));
    }

    public void checkMyTicketsFrom(LottoCompany lottoCompany){
        lottoCompany.check(this.tickets);
    }
}
