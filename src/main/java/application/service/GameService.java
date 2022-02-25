package application.service;

import application.domain.*;
import application.dto.LottoInputDto;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.repository.UserLotteriesRepository;
import application.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

public class GameService {

    private static GameService gameService;
    private UserLotteriesRepository userLotteriesRepository = UserLotteriesRepository.getInstance();
    private UserRepository userRepository = UserRepository.getInstance();

    private GameService() {}

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }

    public LottoShowDto createUser(int money, List<List<Integer>> manualNumbers) {
        List<UserLottery> manualLotteries = manualNumbers.stream()
                .map(UserLottery::new)
                .collect(Collectors.toList());

        User user = userRepository.add(new User(1, money));
        UserLotteries userLotteries = userLotteriesRepository.add(
                new UserLotteries(user.getUserId(), user.getCount() - manualLotteries.size(), manualLotteries));

        return new LottoShowDto(user.getUserId(), userLotteries);
    }

    public LottosResultDto createStatistics(int userId, List<Integer> winningNumber, int bonusNumber) {
        UserLotteries userLotteries = userLotteriesRepository.findByUserId(userId);
        User user = userRepository.findByUserId(userId);
        userLotteries.compareEach(new WinningLottery(winningNumber, bonusNumber));

        Statistics statistics = new Statistics(user, userLotteries);
        return statistics.toLottosResultDto();
    }
}
