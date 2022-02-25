package domain;

import view.InputView;

import java.util.*;

public class ManualTicketOffice extends TicketOffice {

    @Override
    public List<LottoTicket> issueTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        int numberOfManualTicket = InputView.getNumberOfManualTicket();
        if (numberOfManualTicket>0) {
            tickets.addAll(makeManualTickets(numberOfManualTicket));
        }
        return tickets;
    }

    private List<LottoTicket> makeManualTickets(int numberOfManualTicket) {
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요. (응모할 번호 6자리)");
        for (int i = 0; i < numberOfManualTicket; i++) {
            manualLottoTickets.add(new LottoTicket(InputView.getManualNumber()));
        }
        return manualLottoTickets;
    }
}
