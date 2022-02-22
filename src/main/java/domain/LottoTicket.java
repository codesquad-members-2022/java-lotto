package domain;

import java.util.List;

public class LottoTicket {
    private final List<Integer> lottoTicket;

    public LottoTicket(List<Integer> lottoTicket) {
        this.lottoTicket = lottoTicket;
    }

    public String getTicketInfo() {
        return this.lottoTicket.toString();
    }
}
