package PACKAGE_NAME.view;

import PACKAGE_NAME.domain.LottoCompany;
import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTickets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class LottoController {

    private final LottoStore lottoStore = new LottoStore();
    private final LottoCompany lottoCompany = new LottoCompany();

    public LottoTickets get(int money) {
        int ticketCount = money / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoStore.getLottoTickets(ticketCount));

        return lottoTickets;
    }

    public Map<Integer, Integer> getNumberMatch(Set<Integer> winningNumbers, LottoTickets lottoTickets) {
        LottoCompany lottoCompany = new LottoCompany();
        lottoCompany.registWinningNumbers(winningNumbers);
        Map<Integer, Integer> numberMatch = lottoCompany.numberMatch(lottoTickets);
        return numberMatch;
    }

    public void printResult(int money, LottoTickets lottoTickets, Map<Integer, Integer> numberMatch) {
        int sum = lottoTickets.winningAmount(numberMatch);
        System.out.println("당첨금액 총합: " + sum);
        System.out.print("총 수익률은" + lottoTickets.calculateYield(sum, money) + "% 입니다.");
    }

    public void registWinningNumbers(Set<Integer> winningNumbers) {
        lottoCompany.registWinningNumbers(winningNumbers);
    }

    public Map<Integer, Integer> getWinningTickets(LottoTickets lottoTickets) {
        return lottoCompany.numberMatch(lottoTickets);
    }
}
