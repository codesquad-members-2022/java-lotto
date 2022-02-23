package app.lotto.domain;

import java.util.List;

public class LottoGameResult {

    private final List<LottoTicket> allAutoLottoNumbers;
    private final List<LottoTicket> customLottoNumbers;
    private final int amount;
    private final int bonusNumber;
    private final LottoTicket winningNumbers;

    private LottoGameResult(List<LottoTicket> allAutoLottoNumbers, List<LottoTicket> customLottoNumbers, int amount, int bonusNumber, LottoTicket winningNumbers) {
        this.allAutoLottoNumbers = allAutoLottoNumbers;
        this.customLottoNumbers = customLottoNumbers;
        this.amount = amount;
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public List<LottoTicket> getAllAutoLottoNumbers() {
        return allAutoLottoNumbers;
    }

    public List<LottoTicket> getCustomLottoNumbers() {
        return customLottoNumbers;
    }

    public int getAmount() {
        return amount;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public LottoTicket getWinningNumbers() {
        return winningNumbers;
    }

    public static class Builder {
        private List<LottoTicket> allAutoLottoNumbers;
        private List<LottoTicket> customLottoNumbers;
        private int amount;
        private int bonusNumber;
        private LottoTicket winningNumbers;

        public Builder setAllAutoLottoNumbers(List<LottoTicket> allAutoLottoNumbers) {
            this.allAutoLottoNumbers = allAutoLottoNumbers;
            return this;
        }

        public Builder setCustomLottoNumbers(List<LottoTicket> customLottoNumbers) {
            this.customLottoNumbers = customLottoNumbers;
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder setBonusNumber(int bonusNumber) {
            this.bonusNumber = bonusNumber;
            return this;
        }

        public Builder setWinningNumbers(LottoTicket winningNumbers) {
            this.winningNumbers = winningNumbers;
            return this;
        }

        public LottoGameResult build() {
            return new LottoGameResult(allAutoLottoNumbers, customLottoNumbers, amount, bonusNumber, winningNumbers);
        }
    }

}
