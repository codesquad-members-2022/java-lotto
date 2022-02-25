package application.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class UserLotteries {

    private final List<UserLottery> lotteries = new ArrayList<>();

    public UserLotteries(int count) {
        IntStream.range(0, count)
                .forEach((ind) -> lotteries.add(new UserLottery()));
    }

    public UserLotteries(List<Integer> numbers) {
        lotteries.add(new UserLottery(numbers));
    }

    public UserLotteries(int count, List<UserLottery> manualLotteries) {
        this(count);
        lotteries.addAll(manualLotteries);
    }

    public void compareEach(WinningLottery winningLottery) {
        lotteries.stream()
                .forEach(lottery -> lottery.compareLottery(winningLottery));
    }

    public void addUserLottery(List<Integer> numbers) {
        lotteries.add(new UserLottery(numbers));
    }

    public List<UserLottery> get() {
        return lotteries;
    }

}

