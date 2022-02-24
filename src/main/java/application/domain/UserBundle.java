package application.domain;

import application.dto.LottoShowDto;

import java.util.List;
import java.util.stream.Collectors;

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

    public LottoShowDto getLottos() {
        List<List<Integer>> lottos = userLotteries.get().stream()
                .map(Lottery::getNumbers)
                .collect(Collectors.toList());
        return new LottoShowDto(lottos.size(), lottos);
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
