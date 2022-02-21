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
        Map<Rank, Integer> rankResult = new HashMap<>();

        Collection<Integer> values = numOfMatchingResult.values();
        for (int value : values) {
            for (int i = 0; i < Rank.values().length; i++) {
                if (value == Rank.values()[i].getCountOfMatch()) {
                    rankResult.put(Rank.values()[i],
                        rankResult.getOrDefault(Rank.values()[i], 0) + 1);
                }
            }
        }

        int total = 0;
        total += rankResult.getOrDefault(Rank.FIFTH, 0) * Rank.FIFTH.getWinningMoney();
        total += rankResult.getOrDefault(Rank.THIRD, 0) * Rank.THIRD.getWinningMoney();
        total += rankResult.getOrDefault(Rank.SECOND, 0) * Rank.SECOND.getWinningMoney();
        total += rankResult.getOrDefault(Rank.FIRST, 0) * Rank.FIRST.getWinningMoney();

        double earningRate =
            (double) ((total - rankResult.size() * 1000) / (rankResult.size() * 1000)) * 100;

        Output.printResult(rankResult, total, earningRate);
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
            if (lotto.getNumbers().contains(luckyNumber)) {
                count++;
            }
        }
        return count;
    }

    private void init() {
        numOfMatchingResult = new HashMap<>();
    }


}
