package domain.lotto;

import domain.Money;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    private LottoTickets(Money money) {
        long numberOfLottoTickets = money.numberOfBuyableLottoTickets();
        for (long count = 0; count < numberOfLottoTickets; count++) {
            lottoTickets.add(LottoTicket.createRandomTicket());
        }
    }

    public static LottoTickets createRandomTickets(Money money) {
        return new LottoTickets(money);
    }

    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }

}
