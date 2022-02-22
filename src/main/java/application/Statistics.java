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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        counts.keySet().forEach(key -> {
            sb.append(key.matchCount).append("개 일치(")
                .append(key.reward).append("원) - ")
                .append(counts.get(key)).append("개")
                .append(System.lineSeparator());
        });
        return sb.toString();
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
