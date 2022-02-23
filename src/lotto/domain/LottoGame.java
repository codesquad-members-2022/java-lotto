package lotto.domain;

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
        List<Lotto> buyedLottos = getLottos();
        setLuckyNumbers();
        getResult(buyedLottos);
        matchRank();
        printResult();
    }

    private List<Lotto> getLottos() {
        int inputMoney = Input.getInputMoney();
        int numOfMaunalLottos = getManualLottoNumbers();
        int numOfAutoLottos = inputMoney / Lotto.PRICE - numOfMaunalLottos;
        if (numOfAutoLottos < 0) {
            throw new IllegalArgumentException("돈보다 더 많은 수동 번호를 입력하셨습니다.");
        }
        List<Lotto> buyedLottos = lottos.buyLotto(numOfAutoLottos);
        Output.printLottoNum(buyedLottos, numOfMaunalLottos);
        return buyedLottos;
    }

    private int getManualLottoNumbers() {
        int numOfManualLottos = Input.getInputNumbOfLottos();
        Input.getLottoNumbersInfo();
        for (int i = 0; i < numOfManualLottos; i++) {
            List<Integer> lottoNumbers = Input.getLottoNumbers();
            lottos.buyLotto(lottoNumbers);
        }
        return numOfManualLottos;
    }


    private void setLuckyNumbers() {
        List<Integer> luckyNumbers = Input.getLuckyNumbers();
        int bonusNumber = Input.getBonusNumber();
        luckyLotto = new LuckyLotto(luckyNumbers, bonusNumber);
    }

    private double getEarningRate(int numOfLottos) {
        int total = getTotalEarning(rankResult);
        int pay = numOfLottos * Lotto.PRICE;
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
        for (Lotto lotto : numOfMatchingResult.keySet()) {
            boolean isMatchBonusNumber = lotto.getNumbers().contains(luckyLotto.getBonusNumber());
            Rank rank = Rank.create(numOfMatchingResult.get(lotto), isMatchBonusNumber);
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
        Rank[] values = Rank.values();
        for (Rank value : values) {
            rankResult.put(value, 0);
        }
    }

    private void printResult() {
        Output.printResult(rankResult, getEarningRate(numOfMatchingResult.size()));
    }
}
