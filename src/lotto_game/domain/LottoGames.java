package lotto_game.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {
    private List<Lotto> lottoGames;

    public LottoGames() {
        this.lottoGames = new ArrayList<>();
    }

    public void initLottoGames(int numberOfLottoGames) {
        for (int i = 0; i < numberOfLottoGames; i++) {
            Lotto lotto = new Lotto();
            lotto.initLottoNumbers();
            lottoGames.add(lotto);
        }
    }

    public List<Lotto> getLottoList() {
        return lottoGames;
    }
}
