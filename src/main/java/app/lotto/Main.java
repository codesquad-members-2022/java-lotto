package app.lotto;

import app.lotto.domain.LottoController;
import app.lotto.domain.LottoGame;
import app.lotto.domain.LottoTicket;
import app.lotto.view.InputView;
import app.lotto.view.LottoResult;
import app.lotto.view.OutputView;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int amount = InputView.readAmount();
        List<LottoTicket> allShuffledNumbers = purchaseLotto(amount);

        List<Integer> winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();

        printLottoGameResult(amount, allShuffledNumbers, winningNumbers, bonusNumber);
    }

    private static void printLottoGameResult(int amount, List<LottoTicket> allShuffledNumbers, List<Integer> winningNumbers, int bonusNumber) {
        List<LottoResult> lottoResults = LottoGame.processLottoGame(allShuffledNumbers, winningNumbers, bonusNumber);
        long totalProfit = LottoGame.getTotalProfit(lottoResults);

        OutputView.printWinStatistics(lottoResults);
        double result = (totalProfit - amount) / (double) amount * 100.0;
        OutputView.printTotalProfit(result);
    }

    private static List<LottoTicket> purchaseLotto(int amount) {
        OutputView.printLottoCount(LottoController.getLottoCount(amount));

        List<LottoTicket> allShuffledNumbers = LottoController.getAllShuffledNumbers(amount);

        OutputView.printAllSuffledNumbers(allShuffledNumbers);

        return allShuffledNumbers;
    }
}
