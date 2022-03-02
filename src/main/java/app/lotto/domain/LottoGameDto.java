package app.lotto.domain;

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

}
