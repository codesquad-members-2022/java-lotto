package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;
    private final int PRICE = 1000;
    private List<Integer> winningNumbers =new ArrayList<>();
    private Map<Integer, Integer> statistics = new HashMap<>();
    {
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);
    }


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
        for (int i = 0; i < winning.length; i++) {
            winningNumbers.add(Integer.parseInt(winning[i]));
        }
    }

    public void getStatistic(List<LottoTicket> tickets) {
        int matchedNumber = 0;
        for (LottoTicket ticket : tickets) {
            matchedNumber = checkWinningNumber(ticket.getTicketInfo());
            statistics.computeIfPresent(matchedNumber, (k, v) -> v++);
        }
        System.out.println();
    }

    public int calculateProfit() {
        int totalPrize = 0;
        for(Integer matchedNumber: statistics.keySet()){
            totalPrize += (switchPrize(matchedNumber) * statistics.get(matchedNumber));
        }
        return totalPrize;
    }

    private int switchPrize(int matchedNumber){
        switch (matchedNumber){
            case 3:
                return ProfitAmount.FORTH.getPrize();
            case 4:
                return ProfitAmount.THIRD.getPrize();
            case 5:
                return ProfitAmount.SECOND.getPrize();
            default:
                return ProfitAmount.FIRST.getPrize();
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
