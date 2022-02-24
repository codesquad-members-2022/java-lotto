package application;

import application.domain.UserBundle;
import application.domain.Statistics;
import application.domain.UserLotteries;
import application.domain.WinningLottery;
import application.view.InputValidator;
import application.view.InputView;
import application.view.OutputView;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;

    public GameController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

    public void run() {
        UserBundle userBundle = loopGetUserBundle();
        loopRaffle(userBundle);
        loopCalculate(userBundle);
    }

    private UserBundle loopGetUserBundle() {
        while (true) {
            try {
                return getUserBundle();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void loopRaffle(UserBundle userBundle) {
        while (true) {
            try {
                raffle(userBundle);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void loopCalculate(UserBundle userBundle) {
        while (true) {
            try {
                calculate(userBundle);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private UserBundle getUserBundle() {
        UserBundle userBundle = new UserBundle(inputView.getMoney());
        UserLotteries userLotteries = userBundle.getUserLotteries();

        outputView.printCount(userBundle.getCount());
        outputView.printLotteries(userLotteries.get());

        return userBundle;
    }

    private void raffle(UserBundle userBundle) {
        UserLotteries userLotteries = userBundle.getUserLotteries();

        WinningLottery winningLottery = new WinningLottery(
                inputView.getWinningNumbers(),
                inputView.getBonusNumber()
        );
        userLotteries.compareEach(winningLottery);
    }

    private void calculate(UserBundle userBundle) {
        Statistics statistics = new Statistics(userBundle);

        outputView.printStatistics(statistics);
        outputView.printEarningsRate(statistics.getEarningsRate());
    }
}
