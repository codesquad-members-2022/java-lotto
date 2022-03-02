package app.lotto.domain;

import app.lotto.view.InputView;

public class WinningLottoNumbers {

    private final int bonusNumber;
    private final LottoTicket winningNumbers;

    private WinningLottoNumbers(LottoTicket winningNumbers, int bonusNumber) {
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public static WinningLottoNumbers readWinningNumbersAndCreate() {
        return new WinningLottoNumbers(InputView.readWinningNumbers(), InputView.readBonusNumber());
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoTicket getWinningNumbers() {
        return winningNumbers;
    }
}
