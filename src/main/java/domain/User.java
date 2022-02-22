package domain;

import java.util.List;

public class User {
    private final int money;
    private List<Lotto> lottos;

    public User(int money) {
        this.money = money;
    }

    public void buy() {
        lottos = LottoMachine.createLottos(money);
    }
}
