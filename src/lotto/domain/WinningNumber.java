package lotto.domain;

public class WinningNumber {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
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
