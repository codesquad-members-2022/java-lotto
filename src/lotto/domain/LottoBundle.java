package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final int ticketCount;
    private final int paidAmount;

    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoBundle(int paidAmount) {
        validatePositiveInt(paidAmount);
        this.paidAmount = paidAmount;
        this.ticketCount = paidAmount / LottoTicket.PRICE;
    }

    public void fillWithRandomLottoTickets() {
        for (int i = 0; i < ticketCount; i++){
            lottoTickets.add(LottoFactory.issueLottoTicketWithRandomNumbers());
        }
    }

    public int count() {
        return ticketCount;
    }

    public LottoTicket getTicket(int index) {
        return lottoTickets.get(index);
    }

    public int getPaidAmount() {
        return paidAmount;
    }

    private void validatePositiveInt(int paidAmount) {
        if (paidAmount <= 0) {
            throw new IllegalArgumentException("돈의 금액은 양의 정수여야 합니다.");
        }
    }
}
