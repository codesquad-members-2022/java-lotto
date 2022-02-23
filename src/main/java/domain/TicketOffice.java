package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class TicketOffice {
    private final List<Integer> lottoNumber = new ArrayList<>();
    private final int SELECTABLE_NUMBER = 45;
    private final int SELECTED_NUMBER = 6;
    private final int PRICE = 1000;
    private int TOTAL_PRICE;
    private int bonusNumber;
    private LottoTicket winningTicket;
    private Map<Integer, Integer> statistics = new HashMap<>();
    {
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);
        statistics.put(7, 0);
    }


    public TicketOffice() {
        setLottoNumber();
    }

    private void setLottoNumber() {
        for (int i = 1; i <= SELECTABLE_NUMBER; i++) {
            this.lottoNumber.add(i);
        }
    }

    private LottoTicket makeLottoTicket(boolean isAuto) {
        if (!isAuto)
            return new LottoTicket(InputView.getManualNumber());
        List<Integer> ticketNumber = new ArrayList<>();
        Collections.shuffle(lottoNumber);
        for (int i = 0; i < SELECTED_NUMBER; i++) {
            ticketNumber.add(lottoNumber.get(i));
        }
        Collections.sort(ticketNumber);
        return new LottoTicket(ticketNumber);
    }

    public List<LottoTicket> issueTickets() {
        int amount = InputView.getAmount();
        int numberOfTickets = amount / PRICE;
        int change = amount % PRICE;
        TOTAL_PRICE = PRICE * numberOfTickets;
        List<LottoTicket> tickets = new ArrayList<>();
        boolean isAuto = InputView.askIsAuto();
        for (int i = 0; i < numberOfTickets; i++)
            tickets.add(makeLottoTicket(isAuto));
        OutputView.completePurchase(numberOfTickets, change, tickets);
        return tickets;
    }

    public void setWinningTicket() {
        winningTicket = new LottoTicket(InputView.getWinningNumber());
    }

    public void setBonusNumber() { // 추후 당첨 번호에 없는 번호만 받도록 예외처리 필요
        bonusNumber = InputView.getBonusNumber();
    }

    public void getStatistic(List<LottoTicket> tickets) {
        int matchedNumber = 0;
        boolean isBonus = false;
        for (LottoTicket ticket : tickets) {
            matchedNumber = ticket.comparisonWinningTicket(winningTicket);
            isBonus = checkBonusNumber(ticket.getTicketInfo());
            matchedNumber += temp(matchedNumber, isBonus);
            statistics.computeIfPresent(matchedNumber, (k, v) -> v + 1);
        }
        OutputView.showWinningResult(this.statistics, calculateProfit(isBonus));
    }

    private int temp(int matchedNumber, boolean isBonus){
        if (matchedNumber == 5){
            if(isBonus){
                return 2;
            }
        }
        return 0;
    }

    public double calculateProfit(boolean isBonus) {
        int totalPrize = 0;
        for (Integer matchedNumber : statistics.keySet()) {
            totalPrize += (switchPrize(matchedNumber, isBonus) * statistics.get(matchedNumber));
        }
        return ((double) (totalPrize - TOTAL_PRICE) / TOTAL_PRICE) * 100;
    }

    private int switchPrize(int matchedNumber, boolean isBonus) {
        return Rank.designateRank(matchedNumber, isBonus).getPrize();
    }

    private boolean checkBonusNumber(List<Integer> ticketInfo) {
        if (ticketInfo.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
