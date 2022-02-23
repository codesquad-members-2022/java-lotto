package controller;

import java.util.List;
import java.util.Map;

import model.LottoService;
import model.LottoTickets;
import model.Rank;
import view.InputView;
import view.OutputView;

public class Controller {
	public void run() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		LottoService lottoService = new LottoService();

		int purchaseAmount = inputView.getPurchaseAmount();
		LottoTickets lottoTickets = lottoService.publishLottoTickets(purchaseAmount);
		outputView.printTickets(lottoTickets);

		//당첨 번호 입력
		List<Integer> winningNumbers = inputView.getWinningNumbers();
		int bonusNumber = inputView.inputBonusNumber();
		Map<Rank, Integer> result = lottoService.checkResult(lottoTickets, winningNumbers, bonusNumber);
		double earningRate = lottoService.calculateEarningRate(purchaseAmount, result);

		outputView.printResult(result, earningRate);
	}
}
