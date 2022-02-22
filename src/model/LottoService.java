package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
	private static final int TICKET_PRICE = 1000;
	private static final List<Integer> NUMBERS = initLottoNumbers();

	public List<Lotto> publishLottoTickets(int purchaseAmount){
		int ticketCount = calculateAmount(purchaseAmount);
		List<Lotto> tickets = new ArrayList<>();

		for(int i=0; i<ticketCount; i++){
			tickets.add(new Lotto(createTicket()));
		}

		return tickets;
	}

	public Map<Rank, Integer> checkResult(List<Lotto> tickets, List<Integer> winningNumbers){
		Map<Rank, Integer> result = new LinkedHashMap<>() {{
			put(Rank.FOURTH, 0);
			put(Rank.THIRD, 0);
			put(Rank.SECOND, 0);
			put(Rank.FIRST, 0);
		}};

		tickets.forEach(lotto -> {
			int ticketResult = checkTicket(lotto.getTicket(), winningNumbers);
			if (isWinning(ticketResult)) {
				result.put(Rank.checkRank(ticketResult), result.get(ticketResult) + 1);
			}
		});

		return result;
	}

	public double calculateEarningRate(int purchaseAmount, Map<Rank, Integer> result) {
		return (double)calculateWinningAmount(result) / purchaseAmount * 100 - 100;
	}

	private int calculateWinningAmount(Map<Rank, Integer> result) {
		int winningAmount = 0;
		for (Rank rank : result.keySet()) {
			winningAmount += result.get(rank) * rank.getWinningAmount();
		}
		return  winningAmount;
	}

	private boolean isWinning(int ticketResult) {
		return ticketResult >= 3;
	}

	private int checkTicket(List<Integer> ticket, List<Integer> winningNumbers) {
		return (int)winningNumbers.stream()
			.filter(ticket::contains)
			.count();
	}

	private List<Integer> createTicket() {
		Collections.shuffle(NUMBERS);
		return NUMBERS.stream().limit(6).collect(Collectors.toList());
	}

	private int calculateAmount(int purchaseAmount){
		return purchaseAmount / TICKET_PRICE;
	}

	private static List<Integer> initLottoNumbers() {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i<46; i++){
			list.add(i);
		}
		return list;
	}
}
