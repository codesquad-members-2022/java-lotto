package domain;

import java.util.List;

public class LottoMatchChecker {

    private List<Integer> winningNumbers;
    private LottoTicket lottoTicket;
    private int[] winningResult;

    public LottoMatchChecker(List<Integer> winningNumbers, LottoTicket lottoTicket) {
        this.winningNumbers = winningNumbers;
        this.lottoTicket = lottoTicket;
        winningResult = new int[LottoGenerator.LOTTO_NUMBER_SIZE + 1];
    }

    public int[] getWinningResult() {
        List<LottoSheet> tickets = lottoTicket.getLottoSheets();
        tickets.stream().map(LottoSheet::getLottoNumbers).forEach(integerList -> {
            int count = countDuplication(integerList);
            winningResult[count] += 1;
        });

        return winningResult;
    }

    private int countDuplication(List<Integer> integerList) {
        return (int) integerList.stream()
            .filter(integer -> winningNumbers.contains(integer))
            .count();
    }
}
