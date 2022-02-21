package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public List<Lotto> order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return lotteries;
    }
}
