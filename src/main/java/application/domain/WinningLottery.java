package application.domain;

import java.util.List;

public class WinningLottery extends Lottery {

    private final int bonusBall;

    public WinningLottery(List<Integer> numbers, int bonusBall) {
        super(numbers);

        validateBonusBall(numbers, bonusBall);
        this.bonusBall = bonusBall;
    }

    public int getBonusBall() {
        return bonusBall;
    }

    private void validateBonusBall(List<Integer> numbers, int bonusBall) {
        if (numbers.contains(bonusBall)) {
            throw new IllegalArgumentException("보너스 볼은 당첨 번호에 포함될 수 없습니다.\n");
        }
    }
}
