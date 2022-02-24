package application.controller;

import application.domain.*;
import application.dto.BundleDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;
import application.view.InputView;
import application.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private UserBundle userBundle;

    public GameController() {
        inputView = InputView.getInstance();
        outputView = OutputView.getInstance();
    }

//    public void run() {
//        UserBundle userBundle = loopGetUserBundle();
//        loopRaffle(userBundle);
//        loopCalculate(userBundle);
//    }
//
//    private UserBundle loopGetUserBundle() {
//        while (true) {
//            try {
//                return getUserBundle();
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private void loopRaffle(UserBundle userBundle) {
//        while (true) {
//            try {
//                raffle(userBundle);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    private void loopCalculate(UserBundle userBundle) {
//        while (true) {
//            try {
//                calculate(userBundle);
//                break;
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }

    public LottoShowDto getUserBundle(BundleDto dto) {
        int money = dto.getInputMoney();
        List<List<Integer>> manualNumbers = dto.getManualNumbers();

//        UserBundle userBundle = new UserBundle(money, getManualLotteries(manualCount));
        UserBundle userBundle = new UserBundle(money, getManualLotteries(manualNumbers));

//        UserLotteries userLotteries = userBundle.getUserLotteries();
//        outputView.printCount(userBundle.getCount());
//        outputView.printLotteries(userLotteries.get());

        return userBundle.getLottoShowDto();
    }

    public List<UserLottery> getManualLotteries(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream().map(UserLottery::new).collect(Collectors.toList());
    }

    public void raffle(NumberDto dto) {
        List<Integer> winningNumber = dto.getWinningNumber();
        int bonusNumber = dto.getBonusNumber();

        UserLotteries userLotteries = userBundle.getUserLotteries();

        WinningLottery winningLottery = new WinningLottery(
                winningNumber,
                bonusNumber
        );

        userLotteries.compareEach(winningLottery);
    }

    public LottosResultDto calculate() {
        Statistics statistics = new Statistics(userBundle);
        Map<Prize, Integer> prizes = statistics.getCounts();

        List<String> message = prizes.keySet().stream().map(key ->
                String.format("%d개 일치%s%d원) - %d개%s",
                        key.getResult().getMatchCount(),
                        key.getResult().getBonus() != null && key.getResult().getBonus() ? ", 보너스 볼 일치(" : " (",
                        key.getReward(), prizes.get(key),
                        System.lineSeparator())).collect(Collectors.toList());

        double totalRateOfReturn = statistics.getEarningsRate();

        return new LottosResultDto(message, totalRateOfReturn);
    }
}
