package controller;

import java.util.List;
import java.util.Map;

import model.Lotto;
import model.LottoService;
import model.Rank;
import view.InputView;
import view.OutputView;

public class Controller {
	public void run() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		LottoService lottoService = new LottoService();

		int purchaseAmount = inputView.getPurchaseAmount();
		List<Lotto> lottoTickets = lottoService.publishLottoTickets(purchaseAmount);
		outputView.printTickets(lottoTickets);

		List<Integer> winningNumbers = inputView.getWinningNumbers();
		Map<Rank, Integer> result = lottoService.checkResult(lottoTickets, winningNumbers);
		double earningRate = lottoService.calculateEarningRate(purchaseAmount, result);

		outputView.printResult(result, earningRate);
	}
}
