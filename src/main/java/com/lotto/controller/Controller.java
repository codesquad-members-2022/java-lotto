package com.lotto.controller;

import java.util.List;

import com.lotto.model.LottoGame;
import com.lotto.model.LottoResult;
import com.lotto.model.LottoTickets;
import com.lotto.model.WinningLotto;
import com.lotto.util.ValidationUtil;
import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class Controller {
	private static final int TICKET_PRICE = 1_000;
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private LottoGame lottoGame = new LottoGame();

	public void run() {
		inputView.initScanner();

		int purchaseAmount = getPurchaseAmount();
		int manualCount = getManualCount(purchaseAmount);

		LottoTickets lottoTickets = getLottoTickets(purchaseAmount, manualCount);
		outputView.printTickets(lottoTickets);

		WinningLotto winningLotto = getWinningLotto();
		inputView.closeScanner();

		LottoResult result = lottoGame.checkResult(lottoTickets, winningLotto);
		double earningRate = lottoGame.calculateEarningRate(purchaseAmount, result);

		outputView.printResult(result, earningRate);
	}

	private Integer getPurchaseAmount() {
		int purchaseAmount;
		while (true) {
			purchaseAmount = inputView.inputPurchaseAmount();
			if (purchaseAmount < TICKET_PRICE) {
				System.out.printf("%s 이상의 금액을 입력해주세요.", TICKET_PRICE);
				continue;
			}
			break;
		}
		return purchaseAmount;
	}

	private int getManualCount(int purchaseAmount) {
		int manualCount;
		try {
			manualCount = inputView.inputManualCount();
			ValidationUtil.validateManualCountRange(manualCount, purchaseAmount);
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			manualCount = getManualCount(purchaseAmount);
		}
		return manualCount;
	}

	private WinningLotto getWinningLotto() {
		List<Integer> winningNumbers = inputView.inputWinningNumbers();
		int bonusNumber = inputView.inputBonusNumber(winningNumbers);
		WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
		return winningLotto;
	}

	private LottoTickets getLottoTickets(int purchaseAmount, int manualCount) {
		int ticketCount = calculateTicketAmounts(purchaseAmount);
		LottoTickets lottoTickets;
		if (manualCount > 0) {
			List<List<Integer>> manualNumbers = inputView.inputManualNumbers(manualCount);
			lottoTickets = new LottoTickets(ticketCount, manualNumbers);
		} else {
			lottoTickets = new LottoTickets(ticketCount);
		}
		return lottoTickets;
	}

	private int calculateTicketAmounts(int purchaseAmount) {
		return purchaseAmount / TICKET_PRICE;
	}
}
