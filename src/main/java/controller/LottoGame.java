package controller;

import domain.*;

import java.util.List;
import java.util.Map;
import view.InputView;
import view.OutputView;

public class LottoGame {

    public static final int LOTTO_PRICE = 1_000;
    private InputView inputView;
    private OutputView outputView;

    public LottoGame() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        int purchaseMoney = getValidatedPurchaseMoney();
        int purchaseQuantity = purchaseMoney / LOTTO_PRICE;

        LottoTicket lottoTicket = makeLottoTicket(purchaseQuantity);

        WinningSheet winningNumbers = getValidatedWinningSheet();

        Map<Rank, Integer> winningResult = new LottoMatchChecker(winningNumbers, lottoTicket).getWinningResult();
        double profitPercent = new ProfitCalculator(purchaseMoney, winningResult).calculate();

        outputView.printProfitTable(winningResult);
        outputView.printProfit(profitPercent);
    }

    private LottoTicket makeLottoTicket(int purchaseQuantity) {
        int manualLottoQuantity = getValidatedManualLottoQuantity(purchaseQuantity);

        ManualLottoSheet manualLottoNumbers = getValidatedManualLottoNumber(manualLottoQuantity);

        LottoTicket lottoTicket = new LottoTicket();
        lottoTicket.addManualSheets(manualLottoNumbers.getManualNumbers());
        lottoTicket.issue(purchaseQuantity - manualLottoQuantity);

        outputView.printPurchaseConfirmMessage(purchaseQuantity, manualLottoQuantity);
        outputView.printLotto(lottoTicket);
        return lottoTicket;
    }

    public int getValidatedPurchaseMoney() {
        try {
            return inputView.getPurchaseMoney();
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedPurchaseMoney();
    }

    public int getValidatedManualLottoQuantity(int purchaseQuantity) {
        try {
            return inputView.getManualLottoQuantity(purchaseQuantity);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedManualLottoQuantity(purchaseQuantity);
    }

    public ManualLottoSheet getValidatedManualLottoNumber(int manualLottoQuantity) {
        try {
            List<LottoSheet> manualLottoNumbers = inputView.getManualLottoNumbers(manualLottoQuantity);
            ManualLottoSheet manualLottoSheet = new ManualLottoSheet(manualLottoNumbers);
            return manualLottoSheet;
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedManualLottoNumber(manualLottoQuantity);
    }

    public WinningSheet getValidatedWinningSheet() {
        try {
            List<Integer> winningNumbers = inputView.getWinningNumber();
            int bonusNumber = inputView.getBonusNumber();
            return new WinningSheet(winningNumbers, bonusNumber);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요!!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return getValidatedWinningSheet();
    }
}
