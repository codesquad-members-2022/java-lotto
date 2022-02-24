package app.lotto;

import app.lotto.domain.*;
import app.lotto.view.InputView;
import app.lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.readAmount();
        int customLottoCount = InputView.readCustomLottoCount(LottoAutoMachine.getLottoCount(amount));

        LottoTicketManager lottoTicketManager = LottoTicketManager.createWithTotalAmountAndCustomTicketCount(amount, customLottoCount);
        List<LottoTicket> customLottoTickets = lottoTicketManager.getCustomLottoTickets();
        List<LottoTicket> autoLottoTickets = lottoTicketManager.getAutoLottoTickets();

        OutputView.printLottoCount(lottoTicketManager.getCustomTicketCount(), lottoTicketManager.getAutoTicketCount());
        List<LottoTicket> allLottoNumbers = getAllLottoNumbers(customLottoTickets, autoLottoTickets);
        OutputView.printAllLottoNumbers(allLottoNumbers);
        System.out.println();

        LottoTicket winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        System.out.println();

        printLottoGameResult(new LottoGameResult.Builder()
                .setAllAutoLottoNumbers(autoLottoTickets)
                .setCustomLottoNumbers(customLottoTickets)
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
