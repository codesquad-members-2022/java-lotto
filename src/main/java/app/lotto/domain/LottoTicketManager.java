package app.lotto.domain;

import app.lotto.view.InputView;

import java.util.List;

public class LottoTicketManager {

    private static final int TICKET_PRICE = 1000;

    private final int customTicketCount;
    private final int autoTicketCount;

    private LottoTicketManager(int customTicketCount, int autoTicketCount) {
        this.customTicketCount = customTicketCount;
        this.autoTicketCount = autoTicketCount;
    }

    public static LottoTicketManager createWithTotalAmountAndCustomTicketCount(int totalAmount, int customTicketCount) {
        return new LottoTicketManager(customTicketCount, totalAmount / TICKET_PRICE - customTicketCount);
    }

    public int getCustomTicketCount() {
        return customTicketCount;
    }

    public int getAutoTicketCount() {
        return autoTicketCount;
    }

    // 수동 발행 요청
    public List<LottoTicket> getCustomLottoTickets() {
        return InputView.readCustomLottoNumbers(this.customTicketCount);
    }

    // 자동 발행 요청
    public List<LottoTicket> getAutoLottoTickets() {
        return LottoAutoMachine.getAllAutoLottoNumbers(autoTicketCount);
    }

}
