package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyLotteries{

    private final List<Lotto> myLotteries;

    public MyLotteries(List<Lotto> myLotteries) {
        this.myLotteries = myLotteries;
    }

    public Map<Rank, Integer> getResult(WinningNumbers winningNumbers) {
        Map<Rank, Integer> result = new HashMap<>();
        result.put(Rank.rank1, 0);
        result.put(Rank.rank2, 0);
        result.put(Rank.rank3, 0);
        result.put(Rank.rank4, 0);
        result.put(Rank.rank5, 0);
        result.put(Rank.noRank, 0);

        for (Lotto purchasedLottery : myLotteries) {
            int count = 0;
            for (Integer number : winningNumbers.getWinningNumbersWithoutBonus()) {
                if (purchasedLottery.contains(number)) {
                    count++;
                }
            }
            boolean containsBonus = purchasedLottery.contains(winningNumbers.getBonusNumber());
            Rank rank = Rank.getMatchedRank(count, containsBonus);
            result.replace(rank, result.get(rank) + 1);
        }
        return result;
    }

    public int count() {
        return myLotteries.size();
    }

    public List<Lotto> get() {
        return List.copyOf(myLotteries);
    }
}
