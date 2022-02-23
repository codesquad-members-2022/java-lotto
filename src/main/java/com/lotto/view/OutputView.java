package view;

import java.util.List;
import java.util.Map;

import model.Lotto;
import model.LottoTickets;
import model.Rank;

public class OutputView {
	private static final String TICKET_AMOUNT_MESSAGE = "%d개를 구매했습니다.%n";
	private static final String WINNING_RESULT_MESSAGE = "당첨 통계\n---------";

	public void printTickets(LottoTickets tickets) {
		List<Lotto> ticketList = tickets.getTickets();
		System.out.printf(TICKET_AMOUNT_MESSAGE, ticketList.size());

		for (Lotto ticket : ticketList) {
			System.out.println(ticket.getTicket().toString());
		}
	}

	public void printResult(Map<Rank, Integer> result, double earningRate) {
		System.out.println(WINNING_RESULT_MESSAGE);
		for (Rank rank : result.keySet()) {
			System.out.printf("%d개 일치 (%d원)- %d개%n", rank.getCount(), rank.getWinningAmount(), result.get(rank));
		}
		System.out.printf("총 수익률은 %s%%입니다", String.format("%.2f",earningRate));
	}
}
