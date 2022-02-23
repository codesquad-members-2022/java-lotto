package lotto_game.domain;

import java.util.List;

public class LottoTicket {
    private List<Lotto> lottos;

    public LottoTicket(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottosList() {
        return lottos;
    }
}
