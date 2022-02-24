package application.controller;

import application.domain.*;
import application.view.InputView;
import application.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        int money = inputView.getMoney();
        int manualCount = inputView.getManualCount(money);

        UserBundle userBundle = new UserBundle(money, getManualLotteries(manualCount));
        UserLotteries userLotteries = userBundle.getUserLotteries();

        outputView.printCount(userBundle.getCount());
        outputView.printLotteries(userLotteries.get());

        return userBundle;
    }

    private List<UserLottery> getManualLotteries(int manualCount) {
        inputView.requestManual();

        return IntStream.range(0, manualCount)
                .mapToObj((ind) -> new UserLottery(inputView.getManualNumbers()))
                .collect(Collectors.toList());
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
