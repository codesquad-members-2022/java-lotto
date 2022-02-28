package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final int size;
    private int manualTicketCount;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoBundle(int size) {
        validateBundleSize(size);
        this.size = size;
    }

    public static LottoBundle createByCashValue(int cashValue) {
        int size = Math.max(cashValue / LottoTicket.PRICE, 0);
        return new LottoBundle(size);
    }

    public void addManualLottoTicket(LottoTicket lottoTicket) {
        if (manualTicketCount >= size) {
            throw new IndexOutOfBoundsException("수동 복권을 더 발행할 수 없습니다.");
        }
        lottoTickets.add(lottoTicket);
        manualTicketCount++;
    }

    public void addManualLottoTickets(List<LottoTicket> lottoTicketList) {
        for (LottoTicket lottoTicket : lottoTicketList) {
            addManualLottoTicket(lottoTicket);
        }
    }

    public void fillWithRandomLottoTickets() {
        for (int i = manualTicketCount; i < size; i++){
            lottoTickets.add(LottoTicket.withRandomNumbers());
        }
    }

    public int count() {
        return size;
    }

    public int getManualTicketCount() {
        return manualTicketCount;
    }

    public int getAutoTicketCount() {
        return size - manualTicketCount;
    }

    public LottoTicket getTicket(int index) {
        return lottoTickets.get(index);
    }

    public int getCashValue() {
        return size * LottoTicket.PRICE;
    }

    private void validateBundleSize(int size) {
        if (size < 1) {
            throw new IllegalArgumentException("적어도 한 장은 사야 합니다.");
        }
    }
}
