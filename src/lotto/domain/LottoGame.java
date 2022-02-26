package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.view.Input;
import lotto.view.Output;

public class LottoGame {

    private final LottoBundle lottoBundle;
    private final LottoMatcher lottoMatcher;
    private final Input input;
    private final Output output;

    public LottoGame() {
        this.lottoBundle = new LottoBundle();
        this.lottoMatcher = new LottoMatcher();
        this.input = new Input();
        this.output = new Output();
    }

    public void start() {
        getLottos();
        WinningLotto winningLotto = setWinningNumbers();
        getResult(lottoBundle.getLottoBundle(), winningLotto);
        printResult();
    }

    private void getLottos() {
        int inputMoney = input.getInputMoney();
        int numOfMaunalLottos = getManualLottoBundle(inputMoney);
        int numOfAutoLottos = inputMoney / Lotto.PRICE - numOfMaunalLottos;
        try {
            lottoBundle.buyLotto(numOfAutoLottos);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            getLottos();
        }
        output.printLottoNum(lottoBundle.getLottoBundle(), numOfMaunalLottos);
    }

    private int getManualLottoBundle(int inputMoney) {
        int numOfManualLottos = input.getInputNumbOfLottos(inputMoney);
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
            List<Integer> lottoNumbers = input.getLottoNumbers(Input.REQUEST_LOTTO_NUMBERS_INFO);
            lottoBundle.buyLotto(lottoNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            buyManualLotto();
        }
    }

    private WinningLotto setWinningNumbers() {
        List<Integer> luckyNumbers = input.getLottoNumbers(Input.WINNING_NUMBERS_INFO);
        int bonusNumber = input.getBonusNumber();
        try {
            return new WinningLotto(luckyNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return setWinningNumbers();
        }
    }

    private void getResult(List<Lotto> buyedLottos, WinningLotto winningLotto) {
        lottoMatcher.getResult(buyedLottos, winningLotto);
        lottoMatcher.matchRank(winningLotto);
    }

    private void printResult() {
        Map<Rank, Integer> rankResult = lottoMatcher.getRankResult();
        output.printResult(rankResult,
            lottoMatcher.getEarningRate(lottoBundle.getNumberOfLottos()));
    }
}
