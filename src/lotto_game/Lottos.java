package lotto_game;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        this.lottos = new ArrayList<>();
        createLotto(count);
    }

    private void createLotto(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }
}
