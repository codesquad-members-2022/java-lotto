package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LotteryGenerator {

    private final List<Lottery> userLotteries = new ArrayList<>();
    private Lottery winLottery;

    private Statistics stat;

    public Lottery create() {
        return Lottery.generate();
    }

    public void playLottery(int count) {
        for (int idx = 0; idx < count; idx++) {
            userLotteries.add(Lottery.generate());
        }
    }

    public void selectWinLottery(List<Integer> numbers) {
        winLottery = new Lottery(numbers);
    }

    public void compareEach() {
        for (Lottery lottery : userLotteries) {
            for (int idx = 0; idx < Lottery.COUNT; idx++) {
                Integer number = winLottery.getNumbers().get(idx);

                if (lottery.getNumbers().contains(number)) {
                    lottery.addMatchCount();
                }
            }
        }
    }

    public void addUserLottery(List<Integer> numbers) {
        userLotteries.add(new Lottery(numbers));
    }

    public List<Lottery> getUserLotteries() {
        return userLotteries;
    }

    public Lottery getWinLottery() {
        return winLottery;
    }

    public List<Integer> getMatchCounts() {
        return userLotteries.stream()
            .map(Lottery::getMatchCount)
            .collect(Collectors.toList());
    }

}

