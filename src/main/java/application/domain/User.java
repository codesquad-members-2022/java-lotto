package application.domain;

import application.dto.LottoShowDto;

import java.util.List;
import java.util.stream.Collectors;

public class User {

    public static final int PRICE = 1_000;

    private final int userId;
    private final int money;
    private final int count;

    public User(int userId, int money) {
        this.userId = userId;
        this.money = money;

        count = money / PRICE;
    }

    public int getUserId() { return userId; }

    public int getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }

}
