package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoService {
	private static final int TICKET_PRICE = 1000;
	private static final Map<Integer, Integer> WINNING_AMOUNT = new HashMap<>(){{
		put(3, 5_000);
		put(4, 50_000);
		put(5, 15_000_000);
		put(6, 2_000_000_000);
	}};
	private static final List<Integer> NUMBERS = initLottoNumbers();

	public List<Lotto> publishLottoTickets(int purchaseAmount){
		int ticketCount = calculateAmount(purchaseAmount);
		List<Lotto> tickets = new ArrayList<>();

		for(int i=0; i<ticketCount; i++){
			tickets.add(new Lotto(createTicket()));
		}

		return tickets;
	}

	public Map<Integer, Integer> checkResult(List<Lotto> tickets, List<Integer> winningNumbers){
		Map<Integer, Integer> result = new HashMap<>(){{
			put(3, 0);
			put(4, 0);
			put(5, 0);
			put(6, 0);
		}};

		tickets.forEach(lotto -> {
			int ticketResult = checkTicket(lotto.getTicket(), winningNumbers);
			if (isWinning(ticketResult)) {
				result.put(ticketResult, result.get(ticketResult) + 1);
			}
		});

		return result;
	}

	public double calculateEarningRate(int purchaseAmount, Map<Integer, Integer> result) {

		return (double)calculateWinningAmount(result) / purchaseAmount * 100 - 100;
	}

	public Map<Integer, Integer> getWinningAmount() {
		return WINNING_AMOUNT;
	}

	private int calculateWinningAmount(Map<Integer, Integer> result) {
		int winningAmount = 0;
		for (Integer key : result.keySet()) {
			winningAmount += result.get(key) * WINNING_AMOUNT.get(key);
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
