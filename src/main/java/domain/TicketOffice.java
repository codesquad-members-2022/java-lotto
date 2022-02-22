package domain;

import view.InputView;
import view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int MAX_NUMBER = 45;
    private final int PRICE = 1000;
    private List<Integer> winningNumbers =new ArrayList<>();

    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= MAX_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    private LottoTicket makeNewLottoTicket() {
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < 6; i++) {
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
}
