package application;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private final Map<Prize, Integer> counts = new LinkedHashMap<>() {{
        put(Prize.THREE, 0);
        put(Prize.FOUR, 0);
        put(Prize.FIVE, 0);
        put(Prize.SIX, 0);
    }};

    public Statistics(List<Lottery> lotteries) {
        for (Lottery lottery : lotteries) {
            int match = lottery.getMatchCount();
            if (match < Prize.THREE.matchCount) {
                continue;
            }
            Prize prize = Prize.create(match);
            counts.put(prize, counts.get(prize) + 1);
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

    public static void main(String[] args) {
        LotteryGenerator lotteryGenerator = new LotteryGenerator();

        lotteryGenerator.playLottery(10000);
        lotteryGenerator.selectWinLottery(List.of(1, 2, 3, 4, 5, 6));
        lotteryGenerator.compareEach();

        Statistics statistics = new Statistics(lotteryGenerator.getUserLotteries());
        System.out.println(statistics);
    }

}
