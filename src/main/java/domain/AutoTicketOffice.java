package domain;

import java.util.*;

public class AutoTicketOffice extends TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;

    public AutoTicketOffice() {
        setLottoNumber();
    }

    @Override
    public List<LottoTicket> issueTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int j = 0; j < numberOfTickets; j++){
            tickets.add(makeAutoTicket());
        }
        return tickets;
    }

    private LottoTicket makeAutoTicket() {
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < SELECTED_NUMBER; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    private void setLottoNumber() {
        for (int i = 1; i <= SELECTABLE_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }
}
