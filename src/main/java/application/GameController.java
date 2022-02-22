package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LotteryGenerator lotteryGenerator;

    public GameController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
        lotteryGenerator = new LotteryGenerator();
    }

    public void run() {
        int money = inputView.getMoney();
        lotteryGenerator.playLottery(money / 1_000);
        outputView.printCount(money / 1_000);
        outputView.printLotteries(lotteryGenerator.getUserLotteries());

        String winningNumber = inputView.winningNumber();
        String[] split = winningNumber.trim().split(",");

        List<Integer> numbers = Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        lotteryGenerator.selectWinLottery(numbers);
        lotteryGenerator.compareEach();
        Statistics statistics = new Statistics(lotteryGenerator.getUserLotteries());
        outputView.printStatistics(statistics);
        outputView.printEarningsRate(statistics.getEarningsRate(money));
    }

}
