import java.util.Arrays;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
        matchRank();

        int total = getTotalEarning(rankResult);
        double earningRate = getEarningRate(numOfMatchingResult.size(), total);

        Output.printResult(rankResult, total, earningRate);
    }

    private double getEarningRate(int numOfLottos, int total) {
        return
            (double) ((total - numOfLottos * Lotto.LOTTO_PRICE) / (numOfLottos * Lotto.LOTTO_PRICE))
                * 100;
    }

    private void matchRank() {
        for (int numOfMatch : numOfMatchingResult.values()) {
            Rank rank = Rank.create(numOfMatch);
            if (!Objects.isNull(rank)) {
                rankResult.put(rank, rankResult.get(rank) + 1);
            }
        }
    }

    private int getTotalEarning(Map<Rank, Integer> rankResult) {
        int total = 0;
        total += rankResult.getOrDefault(Rank.FORTH, 0) * Rank.FORTH.getWinningMoney();
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

    private void init() {
        numOfMatchingResult = new HashMap<>();
        rankResult = new EnumMap<>(Rank.class);

        rankResult.put(Rank.FIRST, 0);
        rankResult.put(Rank.SECOND, 0);
        rankResult.put(Rank.THIRD, 0);
        rankResult.put(Rank.FORTH, 0);
    }


}
