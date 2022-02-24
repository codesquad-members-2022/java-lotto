package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoCompany {
    private LottoTicket winningTicket;
    private int bonusNumber;
    private int totalPrice;
    private final int PRICE = 1000;
    private final Map<Integer, Integer> statistics = new HashMap<>();
    {
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);
        statistics.put(7, 0);
    }

    public void check(List<LottoTicket> tickets){
        setWinningTicket();
        setBonusNumber();
        this.totalPrice = tickets.size() * PRICE;
        getStatistic(tickets);
    }

    public void setWinningTicket() {
        this.winningTicket = new LottoTicket(InputView.getWinningNumber());
    }

    public void setBonusNumber() { // 추후 당첨 번호에 없는 번호만 받도록 예외처리 필요
        this.bonusNumber = InputView.getBonusNumber();
    }

    public void getStatistic(List<LottoTicket> tickets) {
        int matchedNumber;
        boolean isBonus;
        for (LottoTicket ticket : tickets) {
            matchedNumber = ticket.comparisonWinningTicket(this.winningTicket);
            isBonus = ticket.checkBonusNumber(this.bonusNumber);
            matchedNumber += addMatchedForBonus(matchedNumber, isBonus);
            statistics.computeIfPresent(matchedNumber, (k, v) -> v + 1);
        }
        OutputView.showWinningResult(this.statistics, calculateProfit());
    }

    private int addMatchedForBonus(int matchedNumber, boolean isBonus){
        if (matchedNumber == 5 && isBonus){
            return 2;
        }
        return 0;
    }

    public double calculateProfit() {
        int totalPrize = 0;
        for (int matchedNumber : this.statistics.keySet()) {
            totalPrize += (switchPrize(matchedNumber) * statistics.get(matchedNumber));
        }
        return ((double) (totalPrize - totalPrice) / totalPrice) * 100;
    }

    private int switchPrize(int matchedNumber) {
        return Rank.designateRank(matchedNumber).getPrize();
    }
}
