package PACKAGE_NAME.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LottoCompany {
    private static Set<Integer> winningNumbers = new HashSet<>();
    private BonusNumber bonusNumber;
    private RateOfReturnCalculator calculator = new RateOfReturnCalculator();

    public void registWinningNumbers(Set<Integer> inputWinningNumber, BonusNumber bonusNumber) {
        if (winningNumbers.size() != 0) {
            winningNumbers = new HashSet<>();
        }
        winningNumbers.addAll(inputWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> numberMatch(LottoTickets lottoTickets) {
        Map<Rank, Integer> answers = new HashMap<>();

        for (int index = 0; index < lottoTickets.getLottoTickets().size(); index++) {
            LottoTicket lottoTicket = lottoTickets.getLottoTickets().get(index);
            int count = lottoTicket.countAnswer(winningNumbers);
            Rank rank = Rank.getRank(count);
            answers.put(rank, answers.getOrDefault(rank, 0) + 1);
        }
        int winningPrize = lottoTickets.getWinningPrize(answers);
        int purchaseAmount = lottoTickets.getLottoTickets().size() * 1000;
        System.out.println(calculator.calculateRateOfReturn(winningPrize, purchaseAmount));
        lottoTickets.getWinningPrize(answers);
        return answers;
    }
}
