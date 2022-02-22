package view;

import domain.LottoTicket;

import java.util.List;

public class OutputView {
    private final int SELECTED_NUMBER = 6;

    public static void completePurchase(int numberOfTickets, int change, List<LottoTicket> tickets) {
        System.out.println(numberOfTickets + "개를 구매했습니다.");
        System.out.println("거스름돈은 " + change + "원 입니다.");

        for (LottoTicket ticket : tickets) {
            System.out.println(ticket.getTicketInfo().toString());
        }
    }
}
