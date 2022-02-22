package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int MAX_NUMBER = 45;

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
}
