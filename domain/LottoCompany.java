package PACKAGE_NAME.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LottoCompany {

    private static Set<Integer> winningNumbers = new HashSet<>();
    private BonusNumber bonusNumber;

    private static final int DEFAULT_VALUE = 0;
    private static final int ONE = 1;


    public void registWinningNumbers(Set<Integer> inputWinningNumber, BonusNumber bonusNumber) {
        if (winningNumbers.size() != 0) {
            winningNumbers = new HashSet<>();
        }
        winningNumbers.addAll(inputWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getMatchOfRank(LottoTickets lottoTickets) {
        Map<Rank, Integer> answers = new HashMap<>();

        for (int index = 0; index < lottoTickets.getLottoTickets().size(); index++) {
            LottoTicket lottoTicket = lottoTickets.getLottoTickets().get(index);
            Rank rank = lottoTicket.getRank(winningNumbers,bonusNumber);
            answers.put(rank, answers.getOrDefault(rank, DEFAULT_VALUE) + ONE);
        }
        return answers;
    }
}
