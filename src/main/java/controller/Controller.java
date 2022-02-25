package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.LinkedHashMap;
import java.util.List;

public class Controller {

    public void run() {
        int purchasingAmount = getProperPurchaseAmount();
        int purchaseQuantity = LottoCashier.getLottoAmount(purchasingAmount);

        List<LottoSheet> lottoTicket = LottoTicketIssuer.getLottoTicket(purchaseQuantity);
        OutputView.printLotto(lottoTicket, purchaseQuantity);

        WinningNumbers winningNumbers = getProperWinningNumbers();

        LinkedHashMap<Rank, Integer> winningResult = new LottoMatchChecker(winningNumbers, lottoTicket).getWinningResult();

        double profitPercent = new ProfitCalculator(purchasingAmount, winningResult).calculate();

        OutputView.printProfitTable(winningResult);
        OutputView.printProfit(profitPercent);
    }

    public int getProperPurchaseAmount() {
        try {
            return InputView.getPurchasingAmount();
        } catch (NumberFormatException e) {
            System.out.println("숫자 형태로 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getProperPurchaseAmount();
    }

    public WinningNumbers getProperWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputView.getWinningNumber();
            int bonusNumber = InputView.getBonusNumber();
            return new WinningNumbers(winningNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("숫자 형태로 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getProperWinningNumbers();
    }
}
