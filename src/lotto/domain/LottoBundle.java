package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final int size;
    private int manualTicketCount;
    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoBundle(int size) {
        validatePositiveInt(size);
        this.size = size;
    }

    public static LottoBundle createByCashValue(int cashValue) {
        return new LottoBundle(cashValue / LottoTicket.PRICE);
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

    private void validatePositiveInt(int paidAmount) {
        if (paidAmount <= 0) {
            throw new IllegalArgumentException("돈의 금액은 양의 정수여야 합니다.");
        }
    }
}
