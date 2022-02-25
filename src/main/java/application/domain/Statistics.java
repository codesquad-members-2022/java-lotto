package application.domain;

import application.dto.LottosResultDto;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Statistics {

    private final Map<Prize, Integer> counts = new EnumMap<>(Prize.class);
    private final int money;

    public Statistics(User user, UserLotteries userLotteries) {
        money = user.getMoney();

        Arrays.stream(Prize.values())
            .forEach(prize -> counts.put(prize, 0));

        userLotteries.get().stream()
                .map(UserLottery::getResult)
                .map(Prize::create)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(p -> counts.put(p, counts.get(p) + 1));
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

    public LottosResultDto toLottosResultDto() {
        return new LottosResultDto(counts, getEarningsRate());
    }
}
