package application.service;

import application.domain.*;
import application.dto.LottoShowDto;
import application.dto.LottosResultDto;
import application.repository.UserLotteriesRepository;
import application.repository.UserRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class GameService {

    private static GameService gameService;
    private final UserLotteriesRepository userLotteriesRepository = UserLotteriesRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    private GameService() {}

    public static GameService getInstance() {
        if (gameService == null) {
            gameService = new GameService();
        }
        return gameService;
    }

    public LottoShowDto createUser(int money, List<List<Integer>> manualNumbers) throws NoSuchElementException {
        List<UserLottery> manualLotteries = manualNumbers.stream()
                .map(UserLottery::new)
                .collect(Collectors.toList());

        User user = userRepository.create(money);
        UserLotteries userLotteries = userLotteriesRepository.create(
                user.getUserId(),
                user.getCount() - manualLotteries.size(),
                manualLotteries
        );

        return new LottoShowDto(user.getUserId(), userLotteries);
    }

    public LottosResultDto createStatistics(int userId, List<Integer> winningNumber, int bonusNumber) throws NoSuchElementException{
        UserLotteries userLotteries = userLotteriesRepository.findByUserId(userId);
        User user = userRepository.findByUserId(userId);
        userLotteries.compareEach(new WinningLottery(winningNumber, bonusNumber));

        Statistics statistics = new Statistics(user, userLotteries);
        return statistics.toLottosResultDto();
    }

    public void removeUser(int userId) {
        userRepository.deleteById(userId);
        userLotteriesRepository.deleteById(userId);
    }
}
