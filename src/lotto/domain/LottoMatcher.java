package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoMatcher {

    private final Map<Lotto, Integer> numOfMatchingResult;
    private final Map<Rank, Integer> rankResult;

    public LottoMatcher() {
        this.numOfMatchingResult = new HashMap<>();
        this.rankResult = new EnumMap<>(Rank.class);
    }

    public void getResult(List<Lotto> buyedLottos, WinningLotto winningLotto) {
        for (Lotto lotto : buyedLottos) {
            int count = matchWithWinningNumber(lotto, winningLotto);
            numOfMatchingResult.put(lotto, count);
        }
    }

    private int matchWithWinningNumber(Lotto lotto, WinningLotto winningLotto) {
        int count = 0;
        for (LottoNumber luckyNumber : winningLotto.getNumbers()) {
            count = getNumOfMatch(lotto, count, luckyNumber);
        }
        return count;
    }

    private int getNumOfMatch(Lotto lotto, int count, LottoNumber luckyNumber) {
        if (lotto.getNumbers().contains(luckyNumber)) {
            count++;
        }
        return count;
    }

    public void matchRank(WinningLotto winningLotto) {
        initRankResult();
        for (Lotto lotto : numOfMatchingResult.keySet()) {
            boolean isMatchBonusNumber = lotto.hasBonusNumber(winningLotto.getBonusNumber());
            Rank rank = Rank.create(numOfMatchingResult.get(lotto), isMatchBonusNumber);
            putOnlyWinningLottery(rank);
        }
    }

    private void initRankResult() {
        Rank[] values = Rank.values();
        for (Rank value : values) {
            rankResult.put(value, 0);
        }
    }

    private void putOnlyWinningLottery(Rank rank) {
        if (!Objects.isNull(rank)) {
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
    }

    public double getEarningRate(int numberOfLottos) {
        int prize = getTotalEarning();
        int payment = numberOfLottos * Lotto.PRICE;
        return ((prize - payment) / (double) payment) * 100;
    }

    private int getTotalEarning() {
        int total = 0;
        for (Rank rank : rankResult.keySet()) {
            total += rankResult.get(rank) * rank.getWinningMoney();
        }
        return total;
    }

    public Map<Rank, Integer> getRankResult() {
        return rankResult;
    }
}
