package domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int LOTTO_PRICE = 1000;
    private static final String EXCESS_MONEY_ERROR = "금액을 초과하였습니다.";

    private final List<Lotto> lottos = new ArrayList<>();
    private final List<Rank> ranks = new ArrayList<>();
    private final int countOfSelf;
    private final int money;
    private int profit;

    public User(int money, int countOfSelf) {
        if( money / LOTTO_PRICE < countOfSelf) {
            throw new IllegalArgumentException(EXCESS_MONEY_ERROR);
        }
        this.money = money;
        this.countOfSelf = countOfSelf;
    }

    public void buyLotto(Lotto lotto) {
        lottos.add(lotto);
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

    public int getCountOfSelf() {
        return countOfSelf;
    }

    public int getCountOfAuto() {
        return money / LOTTO_PRICE - countOfSelf;
    }
}
