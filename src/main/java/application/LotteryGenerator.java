package application;

import java.util.ArrayList;
import java.util.List;

public class LotteryGenerator {

    private List<Lottery> userLotteries;
    private Lottery winLottery;

    private Statistics stat;

    public Lottery create() {
        return Lottery.generate();
    }

    public void playLottery(int count) {
        userLotteries = new ArrayList<>();
        for (int idx = 0; idx < count; idx++) {
            userLotteries.add(Lottery.generate());
        }
    }

    public void selectWinLottery(List<Integer> numbers) {
        winLottery = new Lottery(numbers);
    }

    public List<Lottery> getUserLotteries() {
        return userLotteries;
    }

    public Lottery getWinLottery() {
        return winLottery;
    }
}

