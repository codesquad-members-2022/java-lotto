package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
	private static final List<Integer> NUMBERS = initLottoNumbers();

	private final List<Lotto> tickets;


	private LottoTickets(List<Lotto> tickets) {
		this.tickets = tickets;
	}

	public List<Lotto> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	public static LottoTickets createLottoTickets(int ticketCount) {
		List<Lotto> tickets = new ArrayList<>();
		for(int i=0; i<ticketCount; i++){
			tickets.add(createTicketAutomatically());
		}
		return new LottoTickets(tickets);
	}

	private static Lotto createTicketAutomatically(){
		return new Lotto(createTicket());
	}

	private static List<Integer> createTicket() {
		Collections.shuffle(NUMBERS);
		return NUMBERS.stream().limit(6).collect(Collectors.toList());
	}

	private static List<Integer> initLottoNumbers() {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i<46; i++){
			list.add(i);
		}
		return list;
	}
}
