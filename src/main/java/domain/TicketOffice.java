package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;
    private final int PRICE = 1000;


    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= SELECTABLE_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    private LottoTicket makeLottoTicket(boolean isAuto) {
        if (!isAuto)
            return new LottoTicket(InputView.getManualNumber());
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < SELECTED_NUMBER; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    public List<LottoTicket> issueTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        boolean isAuto = InputView.askIsAuto();
        for (int i = 0; i < numberOfTickets; i++)
            tickets.add(makeLottoTicket(isAuto));
        return tickets;
    }

    public int getPrice() {
        return this.PRICE;
    }
}
