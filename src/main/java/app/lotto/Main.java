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
        int customLottoCount = InputView.readCustomLottoCount(LottoController.getLottoCount(amount));

        List<LottoTicket> customLottoNumbers = InputView.readCustomLottoNumbers(customLottoCount);
        List<LottoTicket> allShuffledNumbers = purchaseLotto(amount, customLottoCount);
        OutputView.printAllSuffledNumbers(customLottoNumbers);
        OutputView.printAllSuffledNumbers(allShuffledNumbers);
        System.out.println();

        LottoTicket winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();

        System.out.println();

        printLottoGameResult(amount, allShuffledNumbers, winningNumbers, bonusNumber);
    }

    private static void printLottoGameResult(int amount, List<LottoTicket> allShuffledNumbers, LottoTicket winningNumbers, int bonusNumber) {
        List<LottoResult> lottoResults = LottoGame.processLottoGame(allShuffledNumbers, winningNumbers, bonusNumber);
        long totalProfit = LottoGame.getTotalProfit(lottoResults);

        OutputView.printWinStatistics(lottoResults);
        double result = (totalProfit - amount) / (double) amount * 100.0;
        OutputView.printTotalProfit(result);
    }

    private static List<LottoTicket> purchaseLotto(int amount, int customLottoCount) {
        int autoLottoCount = LottoController.getLottoCount(amount) - customLottoCount;
        OutputView.printLottoCount(autoLottoCount, customLottoCount);

        return LottoController.getAllShuffledNumbers(autoLottoCount);
    }
}
