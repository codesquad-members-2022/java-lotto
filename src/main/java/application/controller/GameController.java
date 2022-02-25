package application.controller;

import application.domain.*;
import application.dto.BundleDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.dto.NumberDto;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GameController {

    private static GameController controller;
    private User userBundle;

    private GameController() {}

    public static GameController getInstance() {
        if (controller == null) {
            controller = new GameController();
        }
        return controller;
    }

    public LottoShowDto getUserBundle(BundleDto dto) {
        int money = dto.getInputMoney();
        List<List<Integer>> manualNumbers = dto.getManualNumbers();

        userBundle = new User(money, getManualLotteries(manualNumbers));
        return userBundle.getLottoShowDto();
    }

    public List<UserLottery> getManualLotteries(List<List<Integer>> manualNumbers) {
        return manualNumbers.stream()
                .map(UserLottery::new)
                .collect(Collectors.toList());
    }

    public LottosResultDto getStatistics(NumberDto dto) {
        raffle(dto);
        return calculate();
    }

    private void raffle(NumberDto dto) {
        List<Integer> winningNumber = dto.getWinningNumber();
        int bonusNumber = dto.getBonusNumber();

        UserLotteries userLotteries = userBundle.getUserLotteries();
        WinningLottery winningLottery = new WinningLottery(winningNumber, bonusNumber);

        userLotteries.compareEach(winningLottery);
    }

    private LottosResultDto calculate() {
        Statistics statistics = new Statistics(userBundle);
        Map<Prize, Integer> prizes = statistics.getCounts();

        double totalRateOfReturn = statistics.getEarningsRate();

        return new LottosResultDto(prizes, totalRateOfReturn);
    }
}
