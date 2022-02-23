package application.domain;

import java.util.List;
import java.util.stream.IntStream;

public class UserLottery extends Lottery {

    private Result result;

    public UserLottery() {
        super();
    }

    public UserLottery(List<Integer> numbers) {
        super(numbers);
    }

    public void compareLottery(WinningLottery winningLottery) {
        int matchCount = compareNumbers(winningLottery.getNumbers());
        boolean bonus = compareBonus(winningLottery.getBonusBall());

        result = new Result(matchCount, bonus);
    }

    public int compareNumbers(List<Integer> winningNumbers) {
        return (int) IntStream.range(0, Lottery.COUNT)
            .map(winningNumbers::get)
            .filter(numbers::contains)
            .count();
    }

    public boolean compareBonus(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    public Result getResult() {
        return result;
    }
}
