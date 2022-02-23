package PACKAGE_NAME.domain;

import PACKAGE_NAME.view.InputView;

import java.util.List;
import java.util.Map;

public class LottoTickets {
    private final List<LottoTicket> lottoTickets;

    InputView inputView = new InputView();

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public int winningAmount(Map<Integer, Integer> answers) {
        int sum = 0;

        for (int answerCount : answers.keySet()) {
            sum += getWinningAmount(answerCount) * answers.getOrDefault(answerCount, 0);
        }
        return sum;
    }

    public double calculateYield(int sum, int inputMoney){
        //수익률 계산 (당첨금 총합 - 로또 구매금액)*100 / 로또 구매금액
        double yield = 0;

        yield = (sum-inputMoney)*100/inputMoney;

        return Math.round(yield*100)/100.0;
    }

    private int getWinningAmount(int answerCount) {
        switch (answerCount) {
            case 3:
                return 5000;
            case 4:
                return 50000;
            case 5:
                return 1500000;
            case 6:
                return 2000000000;
            default:
                return 0;
        }

    }


    public List<LottoTicket> getLottoTickets() {
        return lottoTickets;
    }


}