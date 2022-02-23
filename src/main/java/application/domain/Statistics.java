package application.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Statistics {

    private final Map<Prize, Integer> counts = new EnumMap<>(Prize.class);
    private final int money;

    public Statistics(UserBundle userBundle) {
        UserLotteries userLotteries = userBundle.getUserLotteries();
        money = userBundle.getMoney();

        Arrays.stream(Prize.values())
            .forEach(prize -> counts.put(prize, 0));

        for (UserLottery lottery : userLotteries.get()) {
            Result result = lottery.getResult();

            Optional<Prize> prize = Prize.create(result);
            prize.ifPresent(p -> counts.put(p, counts.get(p) + 1));
        }
    }

    public double getEarningsRate() {
        int reward = counts.keySet().stream()
            .mapToInt(key -> key.reward * counts.get(key))
            .sum();

        return (double) (reward - money) / money;
    }

    public Map<Prize, Integer> getCounts() {
        return counts;
    }

}
