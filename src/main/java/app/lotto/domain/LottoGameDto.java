package app.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGameDto {

    private final List<LottoTicket> allLottoTickets;
    private final WinningLottoNumbers winningLottoNumbers;

    public LottoGameDto(List<LottoTicket> allLottoTickets, WinningLottoNumbers winningLottoNumbers) {
        this.allLottoTickets = allLottoTickets;
        this.winningLottoNumbers = winningLottoNumbers;
    }

    public List<LottoTicket> getAllLottoTickets() {
        return Collections.unmodifiableList(allLottoTickets);
    }

    public WinningLottoNumbers getWinningLottoNumbers() {
        return winningLottoNumbers;
    }

    public static class Builder {
        private final List<LottoTicket> allLottoTickets = new ArrayList<>();
        private WinningLottoNumbers winningLottoNumbers;
        public Builder addAllLottoTickets(List<LottoTicket> lottoTickets) {
            this.allLottoTickets.addAll(lottoTickets);
            return this;
        }

        public Builder setWinningLottoNumbers(WinningLottoNumbers winningLottoNumbers) {
            this.winningLottoNumbers = winningLottoNumbers;
            return this;
        }

        public LottoGameDto build() {
            return new LottoGameDto(allLottoTickets, winningLottoNumbers);
        }
    }

}
