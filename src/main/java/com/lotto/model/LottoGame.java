package com.lotto.model;

import java.util.List;
import java.util.Map;

public class LottoGame {
	public LottoResult checkResult(LottoTickets tickets, WinningLotto winningNumbers) {
		List<Lotto> ticketList = tickets.getTickets();
		LottoResult result = new LottoResult();

		for (Lotto lotto : ticketList) {
			int ticketResult = winningNumbers.compareTicket(lotto.getTicket());
			boolean bonusResult = winningNumbers.compareBonusNumber(lotto.getTicket());
			result.check(ticketResult, bonusResult);
		}
		return result;
	}

	public double calculateEarningRate(int purchaseAmount, LottoResult result) {

		return (double)calculateWinningAmount(result.getResult()) / purchaseAmount * 100 - 100;
	}

	private int calculateWinningAmount(Map<Rank, Integer> result) {
		int winningAmount = 0;
		for (Rank rank : result.keySet()) {
			winningAmount += result.get(rank) * rank.getWinningAmount();
		}
		return winningAmount;
	}
}
