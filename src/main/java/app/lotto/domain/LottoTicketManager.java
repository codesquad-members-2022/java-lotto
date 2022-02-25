package app.lotto.domain;

import app.lotto.view.InputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTicketManager {

    private static final int TICKET_PRICE = 1000;

    private final int customTicketCount;
    private final int autoTicketCount;
    private final List<LottoTicket> customLottoTickets = new ArrayList<>();
    private final List<LottoTicket> autoLottoTickets = new ArrayList<>();

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
    public List<LottoTicket> createCustomLottoTickets() {
        this.customLottoTickets.addAll(InputView.readCustomLottoNumbers(this.customTicketCount));
        return getCustomLottoTickets();
    }

    // 자동 발행 요청
    public List<LottoTicket> createAutoLottoTickets() {
        this.autoLottoTickets.addAll(LottoAutoMachine.getAllAutoLottoNumbers(autoTicketCount));
        return getAutoLottoTickets();
    }

    public List<LottoTicket> getCustomLottoTickets() {
        return Collections.unmodifiableList(customLottoTickets);
    }

    public List<LottoTicket> getAutoLottoTickets() {
        return Collections.unmodifiableList(autoLottoTickets);
    }
}
