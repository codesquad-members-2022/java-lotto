import domain.LottoCompany;
import domain.LottoTicket;
import domain.TicketOffice;
import domain.User;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TicketOffice ticketOffice = new TicketOffice();
        LottoCompany lottoCompany = new LottoCompany();
        User user = new User();
        user.purchaseTicketsFrom(ticketOffice);
        user.checkMyTicketsFrom(lottoCompany);
    }
}
