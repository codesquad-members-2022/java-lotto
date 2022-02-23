package controller;

import domain.LottoCashier;
import domain.LottoMatchChecker;
import domain.WinningNumbersValidator;
import domain.LottoTicketIssuer;
import domain.LottoTicket;
import domain.ProfitCalculator;
import java.util.List;
import view.InputView;
import view.OutputView;

public class Controller {

    private InputView inputView;
    private OutputView outputView;

    public Controller() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        int purchasingAmount = inputView.getPurchasingAmount();
        int purchaseQuantity = LottoCashier.getLottoAmount(purchasingAmount);

        LottoTicket lottoTicket = new LottoTicketIssuer(purchaseQuantity).getLottoTicket();
        outputView.printLotto(lottoTicket, purchaseQuantity);

        List<Integer> winningNumbers = inputView.getWinningNumber();
        int bonusNumber = inputView.getBonusNumber();
        winningNumbers.add(bonusNumber);
        WinningNumbersValidator.validate(winningNumbers);

        int[] winningResult = new LottoMatchChecker(winningNumbers, lottoTicket).getWinningResult();
        Double profitPercent = new ProfitCalculator(purchasingAmount, winningResult).calculate();

        outputView.printProfitTable(winningResult);
        outputView.printProfit(profitPercent);
    }
}
