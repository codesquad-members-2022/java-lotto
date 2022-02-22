package domain;

import java.util.Collections;
import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }



    public List<Integer> getTicketInfo() {
        return Collections.unmodifiableList(this.lottoTicket);
    }

}
