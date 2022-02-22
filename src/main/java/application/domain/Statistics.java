package application.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Statistics {

    private final Map<Prize, Integer> counts = new EnumMap<>(Prize.class) {{
        put(Prize.FIFTH, 0);
        put(Prize.FORTH, 0);
        put(Prize.THIRD, 0);
        put(Prize.SECOND, 0);
        put(Prize.FIRST, 0);
    }};

    public Statistics(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            Result result = lottery.getResult();

            Optional<Prize> prize = Prize.create(result);
            prize.ifPresent(p -> counts.put(p, counts.get(p) + 1));
        }
    }

    public double getEarningsRate(int money) {
        int reward = counts.keySet().stream()
            .mapToInt(key -> key.reward * counts.get(key))
            .sum();

        return (double) (reward - money) / money;
    }

    public Map<Prize, Integer> getCounts() {
        return counts;
    }

}
