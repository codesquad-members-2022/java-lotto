package application;

import application.domain.UserBundle;
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
        UserBundle userBundle = new UserBundle(inputView.getMoney());
        outputView.printCount(userBundle.getCount());
        outputView.printLotteries(userBundle.getUserLottery().getLotteries());

        List<Integer> numbers = getNumbers();
        WinningLottery winningLottery = new WinningLottery(numbers, inputView.getBonusBall());
        userBundle.getUserLottery().compareEach(winningLottery);

        Statistics statistics = new Statistics(userBundle.getUserLottery().getLotteries());
        outputView.printStatistics(statistics);
        outputView.printEarningsRate(statistics.getEarningsRate(userBundle.getMoney()));
    }
    
    public List<Integer> getNumbers() {
        String winningNumber = inputView.winningNumber();
        String[] split = winningNumber.trim().split(",");

        return Arrays.stream(split)
            .map(Integer::parseInt)
            .collect(Collectors.toList());
    }
    
}
