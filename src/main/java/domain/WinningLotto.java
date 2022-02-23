package domain;

import java.util.Set;

public class WinningLotto {

    private Lotto lotto;
    private Ball bonusBall;

    public WinningLotto(Lotto lotto, Ball bonusBall) {
        this.lotto = lotto;
        this.bonusBall = bonusBall;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public boolean isMatch(Set<Ball> balls) {
         return balls.contains(bonusBall);
    }
}
