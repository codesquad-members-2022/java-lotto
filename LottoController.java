package PACKAGE_NAME;

import PACKAGE_NAME.domain.LottoCompany;
import PACKAGE_NAME.domain.LottoStore;
import PACKAGE_NAME.domain.LottoTickets;
import PACKAGE_NAME.view.InputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private final LottoStore lottoStore = new LottoStore();
    public LottoTickets get(int money) {
        int ticketCount = money / 1000;
        LottoTickets lottoTickets = new LottoTickets(lottoStore.getLottoTickets(ticketCount));

        return lottoTickets;
    }

    public Map<Integer, Integer> getNumberMatch(List<Integer> winningNumbers, LottoTickets lottoTickets) {
        LottoCompany lottoCompany = new LottoCompany();
        lottoCompany.notifyAnswer(winningNumbers);
        Map<Integer, Integer> numberMatch = lottoCompany.numberMatch(lottoTickets);
        return numberMatch;
    }

    public void printResult(int money, LottoTickets lottoTickets, Map<Integer, Integer> numberMatch) {
        int sum = lottoTickets.winningAmount(numberMatch);
        System.out.println("당첨금액 총합: " + sum);
        System.out.print("총 수익률은" + lottoTickets.calculateYield(sum, money) + "% 입니다.");
    }
}
