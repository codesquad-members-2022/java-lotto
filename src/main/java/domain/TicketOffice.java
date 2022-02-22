package domain;

import view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int MAX_NUMBER = 45;
    private final int PRICE = 1000;

    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    public LottoTicket getNewLottoTicket() {
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < 6; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    public List<LottoTicket> issueTickets(){
        int amount = InputView.getAmount();
        int numberOfTickets = amount / PRICE;
        List<LottoTicket> Tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
              Tickets.add(getNewLottoTicket());
        }
        return Tickets;
    }
}
