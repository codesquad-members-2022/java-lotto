package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;
    private final int PRICE = 1000;
    private List<Integer> winningNumbers =new ArrayList<>();

    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= SELECTABLE_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    private LottoTicket makeNewLottoTicket() {
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < SELECTED_NUMBER; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    public List<LottoTicket> issueTickets(){
        int amount = InputView.getAmount();
        int numberOfTickets = amount / PRICE;
        int change = amount % PRICE;
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
              tickets.add(makeNewLottoTicket());
        }
        OutputView.completePurchase(numberOfTickets, change, tickets);
        return tickets;
    }

    public void setWinningNumber(){
        String[] winning = InputView.getWinningNumber();
        Arrays.stream(winning)
            .mapToInt(Integer::parseInt)
            .forEach(winningNumbers::add);
    }

    private void getStatistic(List<LottoTicket> tickets) {
        int matchedNumber = 0;
        for (LottoTicket ticket : tickets) {
            matchedNumber = checkWinningNumber(ticket.getTicketInfo());
            
        }
    }

    private int checkWinningNumber(List<Integer> ticketInfo) {
        int count = 0;
        for (Integer number : ticketInfo) {
            count += isWinningNumber(number);
        }
        return count;
    }

    private int isWinningNumber(int number) {
        if (winningNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }
}
