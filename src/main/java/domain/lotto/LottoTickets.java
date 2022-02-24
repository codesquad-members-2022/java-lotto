package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(long numberOfLottoTickets) {
        lottoTickets = new ArrayList<>();
        for (long count = 0; count < numberOfLottoTickets; count++) {
            lottoTickets.add(LottoTicket.createRandomTicket());
        }
    }

    private LottoTickets(List<LottoTicket> tickets) {
        this.lottoTickets = tickets;
    }

    private LottoTickets(LottoTickets... allTickets) {
        this.lottoTickets = new ArrayList<>();

        for (LottoTickets tickets : allTickets) {
            this.lottoTickets.addAll(tickets.lottoTickets);
        }
    }

    public static LottoTickets createRandomTickets(long numberOfLottoTickets) {
        return new LottoTickets(numberOfLottoTickets);
    }


    public static LottoTickets createManualTickets(List<LottoTicket> manualLottoTickets) {
        return new LottoTickets(manualLottoTickets);
    }

    public static LottoTickets merge(LottoTickets manualLottoTickets, LottoTickets randomLottoTickets) {
        return new LottoTickets(manualLottoTickets, randomLottoTickets);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

    public double getPriceSum() {
        return getCountOfLottoTickets() * LottoTicket.LOTTO_TICKET_PRICE;
    }

    public int getCountOfLottoTickets() {
        return lottoTickets.size();
    }
}
