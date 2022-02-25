package application.repository;

import application.domain.UserLotteries;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class UserLotteriesRepository {

    private static UserLotteriesRepository userLotteriesRepository;

    private UserLotteriesRepository() {}

    public static UserLotteriesRepository getInstance() {
        if (userLotteriesRepository == null) {
            userLotteriesRepository = new UserLotteriesRepository();
        }
        return userLotteriesRepository;
    }

    List<UserLotteries> userLotteriesList = new ArrayList<>();

    public UserLotteries add(UserLotteries userLotteries) {
        userLotteriesList.add(userLotteries);
        return userLotteries;
    }

    public UserLotteries findByUserId(int userId) {
        return userLotteriesList.stream()
                .filter(userLotteries -> userLotteries.getUserId() == userId)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("해당 유저의 로또 정보가 존재하지 않습니다"));
    }
}
