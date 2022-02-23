package application.domain;

import java.util.List;

public class UserBundle {

    public static final int PRICE = 1_000;

    private final int money;
    private final int count;
    private final UserLotteries userLotteries;

    public UserBundle(int money, List<UserLottery> manualLotteries) {
        this.money = money;

        count = money / PRICE;
        userLotteries = new UserLotteries(count - manualLotteries.size(), manualLotteries);
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
