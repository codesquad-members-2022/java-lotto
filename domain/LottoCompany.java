package PACKAGE_NAME.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LottoCompany {
    private static Set<Integer> winningNumbers = new HashSet<>();

    public void registWinningNumbers(Set<Integer> inputWinningNumber) {
        if (winningNumbers.size() != 0) {
            winningNumbers = new HashSet<>();
        }
        winningNumbers.addAll(inputWinningNumber);
    }

    public Map<Integer, Integer> numberMatch(LottoTickets lottoTickets) {
        Map<Integer, Integer> answers = new HashMap<>();

        for (int index = 0; index < lottoTickets.getLottoTickets().size(); index++) {
            LottoTicket lottoTicket = lottoTickets.getLottoTickets().get(index);
            int count = lottoTicket.countAnswer(winningNumbers);
            answers.put(count, answers.getOrDefault(count, 0) + 1);
        }
        lottoTickets.winningAmount(answers);
        return answers;
    }
}
