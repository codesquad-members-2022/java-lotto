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
        Boolean bonus = compareBonus(matchCount, winningLottery.getBonusBall());

        result = new Result(matchCount, bonus);
    }

    public int compareNumbers(List<Integer> winningNumbers) {
        return (int) IntStream.range(0, Lottery.COUNT)
            .map(winningNumbers::get)
            .filter(numbers::contains)
            .count();
    }

    public Boolean compareBonus(int matchCount, int bonusBall) {
        if (matchCount == Lottery.COUNT - 1) {
            return numbers.contains(bonusBall);
        }
        return false;
    }

    public Result getResult() {
        return result;
    }
}
