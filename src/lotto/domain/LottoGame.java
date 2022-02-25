package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGame {

    private final LottoBundle lottos;
    private final LottoMatcher lottoMatcher;

    public LottoGame() {
        this.lottos = new LottoBundle();
        this.lottoMatcher = new LottoMatcher();
    }

    public void start() {
        getLottos();
        LuckyLotto luckyLotto = setLuckyNumbers();
        getResult(lottos.getLottoBundle(), luckyLotto);
        printResult();
    }

    private void getLottos() {
        int inputMoney = Input.getInputMoney();
        int numOfMaunalLottos = getManualLottoBundle(inputMoney);
        int numOfAutoLottos = inputMoney / Lotto.PRICE - numOfMaunalLottos;
        try {
            lottos.buyLotto(numOfAutoLottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getLottos();
        }
        Output.printLottoNum(lottos.getLottoBundle(), numOfMaunalLottos);
    }

    private int getManualLottoBundle(int inputMoney) {
        int numOfManualLottos = Input.getInputNumbOfLottos(inputMoney);
        if (numOfManualLottos != 0) {
            getManualLottoNumbers(numOfManualLottos);
        }
        return numOfManualLottos;
    }

    private void getManualLottoNumbers(int numOfManualLottos) {
        for (int i = 0; i < numOfManualLottos; i++) {
            buyManualLotto();
        }
    }

    private void buyManualLotto() {
        try {
            List<Integer> lottoNumbers = Input.getLottoNumbers();
            lottos.buyLotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyManualLotto();
        }
    }

    private LuckyLotto setLuckyNumbers() {
        List<Integer> luckyNumbers = Input.getLuckyNumbers();
        int bonusNumber = Input.getBonusNumber();
        try {
            return new LuckyLotto(luckyNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setLuckyNumbers();
        }
    }

    private void getResult(List<Lotto> buyedLottos, LuckyLotto luckyLotto) {
        lottoMatcher.getResult(buyedLottos, luckyLotto);
        lottoMatcher.matchRank(luckyLotto);
    }

    private void printResult() {
        Map<Rank, Integer> rankResult = lottoMatcher.getRankResult();
        Output.printResult(rankResult, getEarningRate(lottos.getNumberOfLotto(), rankResult));
    }

    private double getEarningRate(int numOfLottos, Map<Rank, Integer> rankResult) {
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
}
