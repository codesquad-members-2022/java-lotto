package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int LOTTO_PRICE = 1000;

    private final int money;
    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Rank> ranks = new ArrayList<>();
    private int currentMoney;
    private int profit;

    public User(int money) {
        this.money = money;
        this.currentMoney = money;
    }

    public boolean buyLotto(Lotto lotto) {
        if (currentMoney < LOTTO_PRICE) {
            return false;
        }
        currentMoney -= LOTTO_PRICE;
        return lottos.add(lotto);
    }

    public void matchWinningLotto(Lotto winningLotto, Ball bonusBall) {
        for (Lotto lotto : lottos) {
            int count = lotto.getMatchBallCount(winningLotto);
            boolean matchBonus = lotto.isMatchBonusBall(bonusBall);
            Rank status = Rank.createRank(count, matchBonus);
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

    public List<Lotto> getLottos() {
        return lottos;
    }
}
