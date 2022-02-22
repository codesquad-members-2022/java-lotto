package view;

import java.util.List;
import java.util.Map;

import model.Lotto;

public class OutputView {
	private static final String TICKET_AMOUNT_MESSAGE = "%d개를 구매했습니다.%n";
	private static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---------";

	public void printTickets(List<Lotto> tickets) {
		System.out.printf(TICKET_AMOUNT_MESSAGE, tickets.size());

		for (Lotto ticket : tickets) {
			System.out.println(ticket.getTicket().toString());
		}
	}

	public void printResult(Map<Integer, Integer> result, Map<Integer, Integer> winningAmount,double earningRate) {
		System.out.println(WINNING_RESULT_MESSAGE);
		for (int count : result.keySet()) {
			System.out.printf("%d개 일치 (%d원)- %d개%n", count, winningAmount.get(count), result.get(count));
		}
		System.out.printf("총 수익률은 %s%%입니다", String.format("%.2f",earningRate));
	}
}
