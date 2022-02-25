package com.lotto.controller;

import java.util.List;

import com.lotto.model.LottoGame;
import com.lotto.model.LottoResult;
import com.lotto.model.LottoTickets;
import com.lotto.model.WinningLotto;
import com.lotto.view.InputView;
import com.lotto.view.OutputView;

public class Controller {
	private InputView inputView = new InputView();
	private OutputView outputView = new OutputView();
	private LottoGame lottoGame = new LottoGame();

	public void run() {
		inputView.initScanner();

		int purchaseAmount = inputView.getPurchaseAmount();
		int manualCount = inputView.inputManualCount();
		LottoTickets lottoTickets;
		if(manualCount > 0){
			List<List<Integer>> manualNumbers = inputView.inputManualNumbers(manualCount);
			lottoTickets = new LottoTickets(purchaseAmount, manualNumbers);
		} else {
			lottoTickets = new LottoTickets(purchaseAmount);
		}

		outputView.printTickets(lottoTickets);

		List<Integer> winningNumbers = inputView.getWinningNumbers();
		int bonusNumber = inputView.inputBonusNumber();
		WinningLotto winningLotto = new WinningLotto(winningNumbers,bonusNumber);
		inputView.closeScanner();

		LottoResult result = lottoGame.checkResult(lottoTickets, winningLotto);
		double earningRate = lottoGame.calculateEarningRate(purchaseAmount, result);

		outputView.printResult(result, earningRate);
	}
}
