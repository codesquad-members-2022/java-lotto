package application.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    public static final int COUNT = 6;

    private static final List<Integer> candidates;
    private final List<Integer> numbers;
    private Result result;


    static {
        candidates = new ArrayList<>();

        for (int num = MIN_NUM; num <= MAX_NUM; num++) {
            candidates.add(num);
        }
    }

    public Lottery() {
        numbers = new ArrayList<>();
        Collections.shuffle(candidates);

        for (int idx = 0; idx < COUNT; idx++) {
            numbers.add(candidates.get(idx));
        }
    }

    public Lottery(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void compareLottery(WinningLottery winningLottery) {
        int matchCount = compareNumbers(winningLottery.getNumbers());
        boolean bonus = compareBonus(winningLottery.getBonusBall());

        result = new Result(matchCount, bonus);
    }

    public int compareNumbers(List<Integer> winningNumbers) {
        int count = 0;

        for (int idx = 0; idx < Lottery.COUNT; idx++) {
            Integer number = winningNumbers.get(idx);

            if (numbers.contains(number)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean compareBonus(int bonusBall) {
        return numbers.contains(bonusBall);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Result getResult() {
        return result;
    }

}
