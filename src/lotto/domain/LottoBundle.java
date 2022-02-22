package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoBundle {
    private final int ticketCount;

    private final List<LottoTicket> lottoTickets = new ArrayList<>();

    public LottoBundle(int paidAmount) {
        validatePositiveInt(paidAmount);
        this.ticketCount = paidAmount / LottoTicket.PRICE;
    }

    public void issueLottoTicketsWithRandomNumbers() {
        for (int i = 0; i < ticketCount; i++){
            lottoTickets.add(new LottoTicket());
        }
    }

    private void validatePositiveInt(int paidAmount) {
        if (paidAmount <= 0) {
            throw new IllegalArgumentException("돈의 금액은 양의 정수여야 합니다.");
        }
    }
}
