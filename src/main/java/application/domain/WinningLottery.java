package application.domain;

import java.util.List;

public class WinningLottery extends Lottery {

    private final int bonusBall;

    public WinningLottery(List<Integer> numbers, int bonusBall) {
        super(numbers);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }
}
