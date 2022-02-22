package application;

import application.domain.UserLottery;
import application.domain.Statistics;
import application.domain.WinningLottery;
import application.view.InputView;
import application.view.OutputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void run() {
        int money = inputView.getMoney();
        int count = money / 1_000;

        UserLottery userLottery = new UserLottery(count);
        outputView.printCount(count);
        outputView.printLotteries(userLottery.getLotteries());

        String winningNumber = inputView.winningNumber();
        String[] split = winningNumber.trim().split(",");

        List<Integer> numbers = Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int bonusBall = inputView.getBonusBall();
        WinningLottery winningLottery = new WinningLottery(numbers, bonusBall);
        userLottery.compareEach(winningLottery);

        Statistics statistics = new Statistics(userLottery.getLotteries());
        outputView.printStatistics(statistics);
        outputView.printEarningsRate(statistics.getEarningsRate(money));
    }

}
