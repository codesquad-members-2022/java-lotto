package application.repository;

import application.domain.UserLotteries;
import application.domain.UserLottery;

import java.util.*;

public class UserLotteriesRepository {

    private static final String LOTTERIES_NOT_FOUND = "해당 유저의 로또 정보가 존재하지 않습니다.";

    private static UserLotteriesRepository userLotteriesRepository;

    private UserLotteriesRepository() {}

    public static UserLotteriesRepository getInstance() {
        if (userLotteriesRepository == null) {
            userLotteriesRepository = new UserLotteriesRepository();
        }
        return userLotteriesRepository;
    }

    Map<Integer, UserLotteries> userLotteriesMap = new HashMap<>();

    public UserLotteries create(int userId, List<UserLottery> manualLotteries) {
        UserLotteries userLotteries = new UserLotteries(userId, manualLotteries);
        userLotteriesMap.put(userId, userLotteries);
        return userLotteries;
    }

    public UserLotteries findByUserId(int userId) {
        return Optional.ofNullable(userLotteriesMap.get(userId))
                .orElseThrow(() -> new NoSuchElementException(LOTTERIES_NOT_FOUND));
    }

    public void deleteById(int userId) {
        Optional.of(userLotteriesMap.remove(userId))
                .orElseThrow(() -> new NoSuchElementException(LOTTERIES_NOT_FOUND));
    }
}
