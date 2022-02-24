package controller;

import domain.*;

import java.util.LinkedHashMap;
import java.util.List;

import view.InputView;
import view.OutputView;

public class LottoGame {

    public static final int LOTTO_PRICE = 1_000;

    public void run() {
        int purchasingMoney = getValidatedPurchaseMoney();
        int purchaseQuantity = purchasingMoney / LOTTO_PRICE;

        int manualLottoQuantity = getValidatedManualLottoQuantity(purchaseQuantity);

        List<LottoSheet> manualLottoNumbers = InputView.getManualLottoNumbers(manualLottoQuantity);

        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addManualSheets(manualLottoNumbers);
        lottoTicket.issue(purchaseQuantity - manualLottoQuantity);
        OutputView.printPurchaseConfirmMessage(purchaseQuantity, manualLottoQuantity);
        OutputView.printLotto(lottoTicket);

        WinningNumbers winningNumbers = getValidatedWinningNumbers();

        LinkedHashMap<Rank, Integer> winningResult = new LottoMatchChecker(winningNumbers, lottoTicket).getWinningResult();

        Double profitPercent = new ProfitCalculator(purchasingMoney, winningResult).calculate();

        OutputView.printProfitTable(winningResult);
        OutputView.printProfit(profitPercent);
    }

    public int getValidatedPurchaseMoney() {
        try {
            return InputView.getPurchasingMoney();
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하셨습니다!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedPurchaseMoney();
    }

    public int getValidatedManualLottoQuantity(int purchaseQuantity) {
        try {
            return InputView.getManualLottoQuantity(purchaseQuantity);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하셨습니다!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedManualLottoQuantity(purchaseQuantity);
    }

    public WinningNumbers getValidatedWinningNumbers() {
        try {
            List<Integer> winningNumbers = InputView.getWinningNumber();
            int bonusNumber = InputView.getBonusNumber();
            return new WinningNumbers(winningNumbers,bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("잘못된 값을 입력하셨습니다!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedWinningNumbers();
    }
}
