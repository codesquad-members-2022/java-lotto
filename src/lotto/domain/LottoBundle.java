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

    public void addManualLottoTicket(int[] numbers) {
        lottoTickets.add(LottoFactory.issueLottoTicketWithSelectNumbers(numbers));
        manualTicketCount++;
    }

    public void fillWithRandomLottoTickets() {
        for (int i = manualTicketCount; i < size; i++){
            lottoTickets.add(LottoFactory.issueLottoTicketWithRandomNumbers());
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
        if (size < 0) {
            throw new IllegalArgumentException("크기가 음수가 되어서는 안됩니다.");
        }
    }
}
