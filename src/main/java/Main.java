import domain.LottoTicket;
import domain.TicketOffice;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TicketOffice to = new TicketOffice();
        List<LottoTicket> tickets = to.issueTickets();
        to.setWinningNumber();
        to.getStatistic(tickets);
        int prize = to.calculateProfit();
        System.out.println(prize);
    }
}
