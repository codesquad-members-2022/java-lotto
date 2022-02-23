package application;

import application.domain.UserBundle;
import application.domain.Statistics;
import application.domain.UserLotteries;
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
        UserBundle userBundle = new UserBundle(inputView.getMoney());
        UserLotteries userLotteries = userBundle.getUserLotteries();
        outputView.printCount(userBundle.getCount());
        outputView.printLotteries(userLotteries.get());

        WinningLottery winningLottery = new WinningLottery(getNumbers(), inputView.getBonusNumber());
        userLotteries.compareEach(winningLottery);

        Statistics statistics = new Statistics(userBundle);
        outputView.printStatistics(statistics);
        outputView.printEarningsRate(statistics.getEarningsRate());
    }

    public List<Integer> getNumbers() {
        String winningNumber = inputView.getWinningNumbers();
        String[] split = winningNumber.trim().split(",");

        return Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
    
}
