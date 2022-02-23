package application.domain;

public class UserBundle {

    private final int PRICE = 1_000;

    private final int money;
    private final int count;
    private final UserLotteries userLotteries;

    public UserBundle(int money) {
        this.money = money;

        count = money / PRICE;
        userLotteries = new UserLotteries(count);
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
