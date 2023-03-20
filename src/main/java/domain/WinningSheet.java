package domain;

import java.util.List;

public class WinningSheet {

    private LottoSheetValidator lottoNumberValidator;
    private final List<Integer> winningNumbers;

    public WinningSheet(List<Integer> winningNumbers, int bonusNumber) throws IllegalArgumentException {
        lottoNumberValidator = new LottoSheetValidator();
        winningNumbers.add(bonusNumber);
        lottoNumberValidator.validate(winningNumbers, LottoGenerator.LOTTO_NUMBER_SIZE + 1);
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
