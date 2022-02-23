package lotto.domain;

import java.util.List;

public class WinningNumber {
    private final List<LottoNumber> winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber() {
        LottoNumbers pool = new LottoNumbers();
        this.winningNumbers = pool.generateRandomLottoNumbers();
        this.bonusNumber = pool.generateRandomBonusNumber();
    }

    public WinningNumber(int[] numbers, int bonusNumber) {
        this.winningNumbers = LottoNumbers.parseNumbers(numbers);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public PrizeDivision evaluateTicket(LottoTicket lottoTicket) {
        return PrizeDivision.getWhichDivision(matchNumbers(lottoTicket), matchBonusNumber(lottoTicket));
    }

    private int matchNumbers(LottoTicket lottoTicket) {
        return winningNumbers.stream()
                .map(lottoTicket::contains)
                .mapToInt(b -> b ? 1 : 0)
                .sum();
    }

    private boolean matchBonusNumber(LottoTicket lottoTicket) {
        return lottoTicket.contains(bonusNumber);
    }
}
