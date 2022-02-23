package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public MyLotteries order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return new MyLotteries(lotteries);
    }
}
