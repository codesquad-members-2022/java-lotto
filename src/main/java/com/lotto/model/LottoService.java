package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoService {
	private static final int TICKET_PRICE = 1000;

	public LottoTickets publishLottoTickets(int purchaseAmount) {
		int ticketCount = calculateAmount(purchaseAmount);
		return LottoTickets.createLottoTickets(ticketCount);
	}

	public Map<Rank, Integer> checkResult(LottoTickets tickets, List<Integer> winningNumbers, int bonusNumber) {
		List<Lotto> ticketList = tickets.getTickets();

		Map<Rank, Integer> result = new LinkedHashMap<>() {{
			put(Rank.FIFTH, 0);
			put(Rank.FOURTH, 0);
			put(Rank.THIRD, 0);
			put(Rank.SECOND, 0);
			put(Rank.FIRST, 0);
		}};

		for (Lotto lotto : ticketList) {
			int ticketResult = checkTicket(lotto.getTicket(), winningNumbers);
			boolean isWinningBonusNumber = checkBonusNumber(lotto.getTicket(), bonusNumber);

			if (isWinning(ticketResult)) {
				Rank rank = Rank.checkRank(ticketResult, isWinningBonusNumber);
				result.put(rank, result.get(rank) + 1);
			}
		}

		return result;
	}

	public double calculateEarningRate(int purchaseAmount, Map<Rank, Integer> result) {
		return (double)calculateWinningAmount(result) / purchaseAmount * 100 - 100;
	}

	private boolean isWinning(int ticketResult) {
		return ticketResult >= 3;
	}

	private int checkTicket(List<Integer> ticket, List<Integer> winningNumbers) {
		return (int)winningNumbers.stream()
			.filter(ticket::contains)
			.count();
	}

	private boolean checkBonusNumber(List<Integer> ticket, int bonusNumber) {
		return ticket.contains(bonusNumber);
	}

	private int calculateWinningAmount(Map<Rank, Integer> result) {
		int winningAmount = 0;
		for (Rank rank : result.keySet()) {
			winningAmount += result.get(rank) * rank.getWinningAmount();
		}
		return winningAmount;
	}

	private int calculateAmount(int purchaseAmount) {
		return purchaseAmount / TICKET_PRICE;
	}

}
