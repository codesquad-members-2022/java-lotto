package domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {

    private final List<LottoTicket> lottoTickets;

    private LottoTickets(long numberOfLottoTickets) {
        validateNumberOfLottoTickets(numberOfLottoTickets);
        lottoTickets = new ArrayList<>();
        for (long count = 0; count < numberOfLottoTickets; count++) {
            lottoTickets.add(LottoTicket.createRandomTicket());
        }
    }

    private void validateNumberOfLottoTickets(long numberOfLottoTickets) {
        if (numberOfLottoTickets < 0) {
            throw new IllegalArgumentException("음수의 랜덤한 로또 티켓을 생성할 수 없습니다.");
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

    /**
     * 로또 티켓들의 문자열 표현을 반환한다.
     * @return lottoTickets가 2개라면 [x, x, x, x, x, x]\n[x, x, x, x, x, x] 형태
     */
    @Override
    public String toString() {
        return lottoTickets.stream()
                .map(LottoTicket::toString)
                .collect(Collectors.joining("\n"));
    }
}
