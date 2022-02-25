package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameResult {

    private final List<LottoTicket> allLottoTickets;
    private final int amount;
    private final WinningLottoNumbers winningLottoNumbers;

    public LottoGameResult(List<LottoTicket> allLottoTickets, int amount, WinningLottoNumbers winningLottoNumbers) {
        this.allLottoTickets = allLottoTickets;
        this.amount = amount;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public List<LottoTicket> getAllLottoTickets() {
        return Collections.unmodifiableList(allLottoTickets);
    }

    public int getAmount() {
        return amount;
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public static class Builder {
        private final List<LottoTicket> allLottoTickets = new ArrayList<>();
        private int amount;
        private WinningLottoNumbers winningLottoNumbers;
        public Builder addAllLottoTickets(List<LottoTicket> lottoTickets) {
            this.allLottoTickets.addAll(lottoTickets);
            return this;
        }

        public Builder setAmount(int amount) {
            this.amount = amount;
            return this;
        }

        public Builder setWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers) {
            this.winningLottoNumbers = winningLottoNumbers;
            return this;
        }

        public LottoGameResult build() {
            return new LottoGameResult(allLottoTickets, amount, winningLottoNumbers);
        }
    }

}
