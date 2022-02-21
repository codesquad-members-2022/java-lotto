import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoGame {

    private final Lottos lottos = new Lottos();

    private Map<Lotto, Integer> numOfMatchingResult;
    private List<Integer> luckyNumbers;
    private Map<Rank, Integer> rankResult;


    public void start() {
        init();
        int inputMoney = Input.getInputMoney("구입금액을 입력해 주세요.");
        List<Lotto> buyedLottos = lottos.buyLotto(inputMoney);
        Output.printLottoNum(buyedLottos);
        this.luckyNumbers = Arrays.stream(Input.getLuckyNumbers()).boxed()
            .collect(Collectors.toList());
        getResult(buyedLottos);
        printResult();
    }

    private void printResult() {
        Collection<Integer> values = numOfMatchingResult.values();
        for (int value : values) {
            matchRank(rankResult, value);
        }

        int total = getTotalEarning(rankResult);
        double earningRate = getEarningRate(values, total);

        Output.printResult(rankResult, total, earningRate);
    }

    private double getEarningRate(Collection<Integer> values, int total) {
        double earningRate =
            (double) ((total - values.size() * 1000) / (values.size() * 1000)) * 100;
        return earningRate;
    }

    private void matchRank(Map<Rank, Integer> rankResult, int value) {
        for (int i = 0; i < Rank.values().length; i++) {
            checkRankings(rankResult, value, i);
        }
    }

    private void checkRankings(Map<Rank, Integer> rankResult, int value, int i) {
        if (value == Rank.values()[i].getCountOfMatch()) {
            rankResult.put(Rank.values()[i],
                rankResult.getOrDefault(Rank.values()[i], 0) + 1);
        }
    }

    private int getTotalEarning(Map<Rank, Integer> rankResult) {
        int total = 0;
        total += rankResult.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.getWinningMoney();
        total += rankResult.getOrDefault(Rank.THIRD, 0) * Rank.THIRD.getWinningMoney();
        total += rankResult.getOrDefault(Rank.SECOND, 0) * Rank.SECOND.getWinningMoney();
        total += rankResult.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.getWinningMoney();
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
        for (int luckyNumber : luckyNumbers) {
            count += getMatchCount(lotto, count, luckyNumber);
        }
        return count;
    }

    private int getMatchCount(Lotto lotto, int count, int luckyNumber) {
        if (lotto.getNumbers().contains(luckyNumber)) {
            count++;
        }
        return count;
    }

    private void init() {
        numOfMatchingResult = new HashMap<>();
        rankResult = new HashMap<>();
    }


}
