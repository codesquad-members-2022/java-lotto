import domain.TicketOffice;

public class Main {
    public static void main(String[] args) {
        TicketOffice to = new TicketOffice();
        to.issueTickets();
        to.setWinningNumber();
    }
}
