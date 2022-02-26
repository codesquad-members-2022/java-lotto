package PACKAGE_NAME.domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LottoCompany {

    private static Set<LottoNumber> winningNumbers = new HashSet<>();
    private BonusNumber bonusNumber;

    private static final int DEFAULT_VALUE = 0;
    private static final int ONE = 1;

    public void registWinningNumbers(Set<LottoNumber> inputWinningNumber, BonusNumber bonusNumber) {
        if (winningNumbers.size() != 0) {
            winningNumbers = new HashSet<>();
        }
        winningNumbers.addAll(inputWinningNumber);
        this.bonusNumber = bonusNumber;
    }

    public Map<Rank, Integer> getMatchOfRank(LottoTickets lottoTickets) {
        Map<Rank, Integer> answers = new HashMap<>();
        int totalSize = lottoTickets.getLottoTickets().size();

        for (int index = 0; index < totalSize; index++) {
            LottoTicket lottoTicket = getLottoTicketByIndex(lottoTickets, index);
            Rank rank = lottoTicket.getRank(winningNumbers,bonusNumber);
            answers.put(rank, answers.getOrDefault(rank, DEFAULT_VALUE) + ONE);
        }
        return answers;
    }

    private LottoTicket getLottoTicketByIndex(LottoTickets lottoTickets, int index) {
        return lottoTickets.getLottoTickets().get(index);
    }
}
