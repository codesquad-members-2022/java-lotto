package application.domain;

import java.util.Arrays;
import java.util.Optional;

public enum Prize {
    FIFTH(new Result(3, null), 5_000),
    FORTH(new Result(4, null), 50_000),
    THIRD(new Result(5, null), 1_500_000),
    SECOND(new Result(5, true), 30_000_000),
    FIRST(new Result(6, false), 2_000_000_000);

    final Result result;
    final int reward;

    Prize(Result result, int reward) {
        this.result = result;
        this.reward = reward;
    }

    public static Optional<Prize> create(Result result) {
        return Arrays.stream(Prize.values())
            .filter(p -> result.equals(p.getResult()))
            .findAny();
    }

    public Result getResult() {
        return result;
    }

    public int getReward() {
        return reward;
    }
}
