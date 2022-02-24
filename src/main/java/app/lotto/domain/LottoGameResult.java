package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameResult {

    private final List<LottoTicket> allLottoTickets;
    private final int amount;
    private final int bonusNumber;
    private final LottoTicket winningNumbers;

    public LottoGameResult(List<LottoTicket> allLottoTickets, int amount, int bonusNumber, LottoTicket winningNumbers) {
        this.allLottoTickets = allLottoTickets;
        this.amount = amount;
        this.bonusNumber = bonusNumber;
        this.winningNumbers = winningNumbers;
    }

    public List<LottoTicket> getAllLottoTickets() {
        return Collections.unmodifiableList(allLottoTickets);
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
        private final List<LottoTicket> allLottoTickets = new ArrayList<>();
        private int amount;
        private int bonusNumber;
        private LottoTicket winningNumbers;

        public Builder addAllLottoTickets(List<LottoTicket> lottoTickets) {
            this.allLottoTickets.addAll(lottoTickets);
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
            return new LottoGameResult(allLottoTickets, amount, bonusNumber, winningNumbers);
        }
    }

}
