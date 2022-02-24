package domain;

import view.InputView;
import view.OutputView;

import java.util.*;

public class LottoCompany {
    private LottoTicket winningTicket;
    private int bonusNumber;
    private int totalPrice;
    private final int PRICE = 1000;
    private final Map<Rank, Integer> statistics = new HashMap<>();


    public void setInitialStatistic() {
        for (Rank rank : Rank.values()) {
            statistics.put(rank, 0);
        }
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
        setInitialStatistic();
        int matchedNumber;
        boolean isBonus;
        Rank currentRank;
        for (LottoTicket ticket : tickets) {
            matchedNumber = ticket.comparisonWinningTicket(this.winningTicket);
            isBonus = ticket.checkBonusNumber(this.bonusNumber);
            currentRank = Rank.designateRank(matchedNumber, isBonus);
            statistics.computeIfPresent(currentRank, (k, v) -> v + 1);
        }
        OutputView.showWinningResult(this.statistics, calculateProfit());
    }

    public double calculateProfit() {
        int totalPrize = 0;
        for (Rank rank : this.statistics.keySet()) {
            totalPrize += rank.getPrize() * statistics.get(rank);
        }
        return ((double) (totalPrize - totalPrice) / totalPrice) * 100;
    }

}
