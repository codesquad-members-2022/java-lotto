package domain;

import java.util.LinkedHashMap;
import java.util.List;

public class LottoMatchChecker {

    private int winningBonusNumber;
    private List<Integer> winningNumbersList;
    private List<LottoSheet> lottoTicket;
    private LinkedHashMap<Rank, Integer> winningResult;

    public LottoMatchChecker(WinningNumbers winningNumbers, LottoTicket lottoTicket) {
        this.winningNumbersList = winningNumbers.getWinningNumbers();
        this.winningBonusNumber = winningNumbersList.remove(winningNumbersList.size() - 1);
        this.lottoTicket = lottoTicket.getLottoTicket();
        winningResult = new LinkedHashMap<>() {{
            put(Rank.FIRST, 0);
            put(Rank.SECOND, 0);
            put(Rank.THIRD, 0);
            put(Rank.FOURTH, 0);
            put(Rank.FIFTH, 0);
        }};
    }

    public LinkedHashMap<Rank, Integer> getWinningResult() {
        lottoTicket.stream()
                .map(LottoSheet::getLottoNumbers)
                .forEach(lottoNumbers -> {
                    int count = countWinningNumbers(lottoNumbers);
                    Rank rank = Rank.valueOf(count, lottoNumbers.contains(winningBonusNumber));
                    pushWinningResult(rank);
                });
        return winningResult;
    }

    private void pushWinningResult(Rank rank) {
        if (rank != null) {
            winningResult.put(rank, winningResult.get(rank) + 1);
        }
    }

    private int countWinningNumbers(List<Integer> integerList) {
        return (int) integerList.stream()
                .filter(integer -> winningNumbersList.contains(integer))
                .count();
    }
}
