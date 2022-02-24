package lotto.domain;

import lotto.view.InputView;
import lotto.view.OutputView;

import javax.naming.SizeLimitExceededException;

public class LottoGame {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void run() {
        // 구입 금액을 입력받아 로또복권 뭉치를 생성한다.
        int paidAmount = inputView.getPaidAmount();
        LottoBundle lottoBundle = LottoBundle.createByCashValue(paidAmount);

        // 수동
        int manualTicketCount = getManualTicketCountUntilSuccessful(lottoBundle);

        addManualTicketsSafely(lottoBundle, manualTicketCount);

        lottoBundle.fillWithRandomLottoTickets();

        outputView.printPurchaseResult(lottoBundle);

        int[] winningNumberInput = inputView.getWinningNumber();
        int bonusNumberInput = inputView.getBonusNumber();
        WinningNumber winningNumber = LottoFactory.selectWinningNumber(winningNumberInput, bonusNumberInput);
        LottoResult lottoResult = LottoResult.of(lottoBundle, winningNumber);

        outputView.printLottoResult(lottoResult);

        inputView.close();
    }

    private void addManualTicketsSafely(LottoBundle lottoBundle, int manualTicketCount) {
        try {
            addManualTickets(lottoBundle, manualTicketCount);
        } catch (SizeLimitExceededException e) {
            System.out.println(e.getMessage());
        }
    }

    private void addManualTickets(LottoBundle lottoBundle, int manualTicketCount) throws SizeLimitExceededException {
        int[][] numbers = inputView.getManualLottoNumbers(manualTicketCount);
        for (int[] number : numbers) {
            lottoBundle.addManualLottoTicket(number);
        }
    }

    private int getManualTicketCountUntilSuccessful(LottoBundle lottoBundle) {
        int manualTicketCount = -1;
        while (manualTicketCount < 0) {
            manualTicketCount = getManualTicketCount(lottoBundle);
        }

        return manualTicketCount;
    }

    private int getManualTicketCount(LottoBundle lottoBundle) {
        try {
            return inputView.getManualTicketCount(lottoBundle.count());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return -1;
    }
}
