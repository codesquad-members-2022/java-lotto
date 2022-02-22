package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoShop {

    public List<Lotto> order(int balance) {
        List<Lotto> lotteries = new ArrayList<>();
        int lottoCount = balance / Lotto.PRICE;
        for (int i = 0; i < lottoCount; i++) {
            lotteries.add(LottoMaker.make());
        }
        return lotteries;
    }

    public Map<Rank, Integer> getResult(List<Lotto> purchasedLotteries,
        WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.rank1, 0);
        result.put(Rank.rank2, 0);
        result.put(Rank.rank3, 0);
        result.put(Rank.rank4, 0);
        result.put(Rank.noRank, 0);

        for (Lotto purchasedLottery : purchasedLotteries) {
            int count = 0;
            for (Integer number : winningNumbers.getWinningNumbersWithoutBonus()) {
                if (purchasedLottery.contains(number)) {
                    count++;
                }
            }
            Rank rank = Rank.getMatchedRank(count);
            result.replace(rank, result.get(rank) + 1);
        }
        return result;
    }
}
