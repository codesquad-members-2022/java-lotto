package application.domain;

import application.dto.LottoShowDto;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    public static final int PRICE = 1_000;

    private final int money;
    private final int count;
    private final UserLotteries userLotteries;

    public User(int money, List<UserLottery> manualLotteries) {
        this.money = money;

        count = money / PRICE;
        userLotteries = new UserLotteries(count - manualLotteries.size(), manualLotteries);
    }

    public LottoShowDto getLottoShowDto() {
        List<List<Integer>> numbersList = userLotteries.get().stream()
                .map(Lottery::getNumbers)
                .collect(Collectors.toList());
        return new LottoShowDto(numbersList.size(), numbersList);
    }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

    public UserLotteries getUserLotteries() {
        return userLotteries;
    }
}
