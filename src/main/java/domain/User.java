package domain;

import java.util.ArrayList;
import java.util.List;

public class User {
    private final int money;
    private int profit;
    private List<Lotto> lottos;
    private List<Rank> ranks = new ArrayList<>();

    public User(int money) {
        this.money = money;
    }

    public void buy() {
        lottos = LottoMachine.createLottos(money);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void matchWinningLotto(Lotto winningLotto) {
        for (Lotto lotto : lottos) {
            int count = lotto.getMatchBallCount(winningLotto);
            Rank status = Rank.createRank(count);
            profit += status.getPrice();
            ranks.add(status);
        }
    }

    public int countRank(Rank rank) {
        return (int) ranks.stream()
                .filter(status -> status.equals(rank))
                .count();
    }

    public double calculateRateOfReturn() {
        return (profit - money) / (double) money * 100;
    }
}
