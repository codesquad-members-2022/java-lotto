package lotto.domain;

public class WinningNumber {
    private final LottoNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        validateDistinctBonusNumber(winningNumbers, bonusNumber);
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

    private void validateDistinctBonusNumber(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 다른 로또 번호와 중복되지 않아야 합니다.");
        }
    }
}
