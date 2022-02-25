package app.lotto.domain;

public class WinningLottoNumbers {

    private int bonusNumber;
    private LottoTicket winningNumbers;

    public WinningLottoNumbers(LottoTicket winningNumbers, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoTicket getWinningNumbers() {
        return winningNumbers;
    }
}
