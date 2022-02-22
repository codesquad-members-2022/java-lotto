package lotto.domain;

import java.math.BigInteger;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGame {

    private final Lottos lottos = new Lottos();
    private final Map<Lotto, Integer> numOfMatchingResult = new HashMap<>();
    private Map<Rank, Integer> rankResult;
    private LuckyLotto luckyLotto;

    public void start() {
        List<Lotto> buyedLottos = lottos.buyLotto(Input.getInputMoney());
        Output.printLottoNum(buyedLottos);
        setLuckyNumbers();
        getResult(buyedLottos);
        matchRank();
        printResult();
    }

    private void setLuckyNumbers() {
        int[] luckyNumbers = Input.getLuckyNumbers();
        luckyLotto = new LuckyLotto(luckyNumbers);
    }

    private double getEarningRate(int numOfLottos) {
        int total = getTotalEarning(rankResult);
        int pay = numOfLottos * Lotto.LOTTO_PRICE;
        return
            ((total - pay) / (double) pay) * 100;
    }

    private int getTotalEarning(Map<Rank, Integer> rankResult) {
        int total = 0;
        for (Rank rank : rankResult.keySet()) {
            total += rankResult.get(rank) * rank.getWinningMoney();
        }
        return total;
    }

    private void getResult(List<Lotto> buyedLottos) {
        for (Lotto lotto : buyedLottos) {
            int count = matchWithLuckyNumber(lotto);
            numOfMatchingResult.put(lotto, count);
        }
    }

    private int matchWithLuckyNumber(Lotto lotto) {
        int count = 0;
        for (int luckyNumber : luckyLotto.getNumbers()) {
            count = getNumOfMatch(lotto, count, luckyNumber);
        }
        return count;
    }

    private int getNumOfMatch(Lotto lotto, int count, int luckyNumber) {
        if (lotto.getNumbers().contains(luckyNumber)) {
            count++;
        }
        return count;
    }

    private void matchRank() {
        initRankResult();

        for (int numOfMatch : numOfMatchingResult.values()) {
            Rank rank = Rank.create(numOfMatch);
            putOnlyWinningLottery(rank);
        }
    }

    private void putOnlyWinningLottery(Rank rank) {
        if (!Objects.isNull(rank)) {
            rankResult.put(rank, rankResult.get(rank) + 1);
        }
    }

    private void initRankResult() {
        rankResult = new EnumMap<>(Rank.class);
        rankResult.put(Rank.FIRST, 0);
        rankResult.put(Rank.SECOND, 0);
        rankResult.put(Rank.THIRD, 0);
        rankResult.put(Rank.FORTH, 0);
    }

    private void printResult() {
        Output.printResult(rankResult, getEarningRate(numOfMatchingResult.size()));
    }
}
