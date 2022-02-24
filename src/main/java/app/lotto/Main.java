package app.lotto;

import app.lotto.domain.LottoController;
import app.lotto.domain.LottoGame;
import app.lotto.domain.LottoGameResult;
import app.lotto.domain.LottoTicket;
import app.lotto.view.InputView;
import app.lotto.domain.LottoResult;
import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(LottoController.getLottoCount(amount));

        List<LottoTicket> customLottoNumbers = InputView.readCustomLottoNumbers(customLottoCount);
        List<LottoTicket> allAutoLottoNumbers = LottoController.purchaseLotto(amount, customLottoCount);
        List<LottoTicket> allLottoNumbers = getAllLottoNumbers(customLottoNumbers, allAutoLottoNumbers);
        OutputView.printAllLottoNumbers(allLottoNumbers);
        System.out.println();

        LottoTicket winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        System.out.println();

        printLottoGameResult(new LottoGameResult.Builder()
                .setAllAutoLottoNumbers(allAutoLottoNumbers)
                .setCustomLottoNumbers(customLottoNumbers)
                .setAmount(amount)
                .setBonusNumber(bonusNumber)
                .setWinningNumbers(winningNumbers)
                .build());
    }

    private static List<LottoTicket> getAllLottoNumbers(List<LottoTicket> customLottoNumbers, List<LottoTicket> allAutoLottoNumbers) {
        List<LottoTicket> allLottoNumbers = new ArrayList<>();
        allLottoNumbers.addAll(customLottoNumbers);
        allLottoNumbers.addAll(allAutoLottoNumbers);
        return allLottoNumbers;
    }

    private static void printLottoGameResult(LottoGameResult lottoGameResult) {
        List<LottoResult> lottoResults = LottoGame.processLottoGame(lottoGameResult);
        long totalProfit = LottoGame.getTotalProfit(lottoResults);

        OutputView.printWinStatistics(lottoResults);
        double result = (totalProfit - lottoGameResult.getAmount()) / (double) lottoGameResult.getAmount() * 100.0;
        OutputView.printTotalProfit(result);
    }
}
