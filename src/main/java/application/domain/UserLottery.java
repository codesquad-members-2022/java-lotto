package application.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserLottery {

    private final List<Lottery> lotteries = new ArrayList<>();

    public UserLottery(int count) {
        for (int idx = 0; idx < count; idx++) {
            lotteries.add(new Lottery());
        }
    }

    public UserLottery(List<Integer> numbers) {
        lotteries.add(new Lottery(numbers));
    }

    public void compareEach(WinningLottery winningLottery) {
        for (Lottery lottery : lotteries) {
            lottery.compareLottery(winningLottery);
        }
    }

    public void addUserLottery(List<Integer> numbers) {
        lotteries.add(new Lottery(numbers));
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Result> getMatchCounts() {
        return lotteries.stream()
            .map(Lottery::getResult)
            .collect(Collectors.toList());
    }

}

