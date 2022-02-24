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

        printAllLottoTickets(lottoTicketManager);

        LottoTicket winningNumbers = InputView.readWinningNumbers();
        int bonusNumber = InputView.readBonusNumber();
        System.out.println();

        printLottoGameResult(new LottoGameResult.Builder()
                .addAllLottoTickets(customLottoTickets)
                .addAllLottoTickets(autoLottoTickets)
                .setAmount(amount)
                .setWinningNumbers(winningNumbers)
                .setBonusNumber(bonusNumber)
                .build());
    }

    private static void printAllLottoTickets(LottoTicketManager lottoTicketManager) {
        OutputView.printLottoCount(lottoTicketManager.getCustomTicketCount(), lottoTicketManager.getAutoTicketCount());
        OutputView.printAllLottoNumbers(lottoTicketManager.getCustomLottoTickets());
        OutputView.printAllLottoNumbers(lottoTicketManager.getAutoLottoTickets());
        System.out.println();
    }

    private static void printLottoGameResult(LottoGameResult lottoGameResult) {
        List<LottoResult> lottoResults = LottoGame.processLottoGame(lottoGameResult);
        long totalProfit = LottoGame.getTotalProfit(lottoResults);

        OutputView.printWinStatistics(lottoResults);
        double result = (totalProfit - lottoGameResult.getAmount()) / (double) lottoGameResult.getAmount() * 100.0;
        OutputView.printTotalProfit(result);
    }
}
