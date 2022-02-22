package PACKAGE_NAME.domain;

import java.util.*;
import java.util.function.Function;

public class LottoCompany {
    private static List<Integer> winningNumbers = new ArrayList<>();
    private static final Function<Integer, Integer> add = x -> x + 1;

    public List<Integer> getWinningNumbers() {
        Collections.sort(winningNumbers);
        return winningNumbers;
    }

    public void notifyAnswer(List<Integer> inputWinningNumber) {
        if (winningNumbers.size() != 0) {
            winningNumbers = new ArrayList<>();
        }
        winningNumbers.addAll(inputWinningNumber);
    }

    public Map<Integer, Integer> numberMatch(List<LottoTicket> lottoTickets) {
        Map<Integer, Integer> answers = new HashMap<>();

        for (int index = 0; index < lottoTickets.size(); index++) {
            LottoTicket lottoTicket = lottoTickets.get(index);
            int count = lottoTicket.countAnswer(winningNumbers);
            answers.put(count,answers.getOrDefault(count,0)+1);
        }
        return answers;
    }
}
