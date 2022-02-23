package controller;

import domain.*;

import java.util.LinkedHashMap;
import java.util.List;

import view.InputView;
import view.OutputView;

public class Controller {

    public void run() {
        int purchasingAmount = getProperPurchaseAmount();
        int purchaseQuantity = LottoCashier.getLottoAmount(purchasingAmount);

        List<LottoSheet> lottoTicket = LottoTicketIssuer.getLottoTicket(purchaseQuantity);
        OutputView.printLotto(lottoTicket, purchaseQuantity);

        WinningNumbers winningNumbers = getProperWinningNumbers();

        LinkedHashMap<Rank, Integer> winningResult = new LottoMatchChecker(winningNumbers, lottoTicket).getWinningResult();

        Double profitPercent = new ProfitCalculator(purchasingAmount, winningResult).calculate();

        OutputView.printProfitTable(winningResult);
        OutputView.printProfit(profitPercent);
    }

    public int getProperPurchaseAmount() {
        try {
            return InputView.getPurchasingAmount();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하셨습니다!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getProperPurchaseAmount();
    }

    public WinningNumbers getProperWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputView.getWinningNumber();
            int bonusNumber = InputView.getBonusNumber();
            return new WinningNumbers(winningNumbers,bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하셨습니다!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getProperWinningNumbers();
    }
}
