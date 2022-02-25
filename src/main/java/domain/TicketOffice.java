package domain;

import view.InputView;

import java.util.*;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;
    private final int PRICE = 1000;


    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= SELECTABLE_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    private List<LottoTicket> makeManualTickets(int numberOfManualTicket) {
        List<LottoTicket> manualLottoTickets = new ArrayList<>();
        System.out.println("수동으로 구매할 번호를 입력해 주세요. (응모할 번호 6자리)");
        for (int i = 0; i < numberOfManualTicket; i++) {
            manualLottoTickets.add(new LottoTicket(InputView.getManualNumber()));
        }
        return manualLottoTickets;
    }

    private LottoTicket makeAutoTicket() {
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < SELECTED_NUMBER; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    public List<LottoTicket> issueTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        int numberOfManualTicket = InputView.getNumberOfManualTicket();
        if (numberOfManualTicket>0) {
            tickets.addAll(makeManualTickets(numberOfManualTicket));
        }
        for (int j = 0; j < numberOfTickets - numberOfManualTicket; j++){
            tickets.add(makeAutoTicket());
        }
        return tickets;
    }

    public int getPrice() {
        return this.PRICE;
    }
}
