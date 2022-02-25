package com.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTickets {
	private static final List<Integer> numbers;
	private final List<Lotto> tickets;

	static {
		numbers = new ArrayList<>();
		for (int i = 1; i < 46; i++) {
			numbers.add(i);
		}
	}

	public LottoTickets(int ticketCount) {
		this.tickets = new ArrayList<>();
		addAutoTickets(ticketCount);
	}

	public LottoTickets(int ticketCount, List<List<Integer>> manualTickets) {
		this.tickets = new ArrayList<>();
		setManualTickets(manualTickets);
		addAutoTickets(ticketCount- manualTickets.size());
	}

	public List<Lotto> getTickets() {
		return Collections.unmodifiableList(tickets);
	}

	private void addAutoTickets(int autoTicketCount) {
		for (int i = 0; i < autoTicketCount; i++) {
			tickets.add(createAutoTicket());
		}
	}

	private Lotto createAutoTicket() {
		return new Lotto(createRandomNumbers());
	}

	private void setManualTickets(List<List<Integer>> manualTickets) {
		for (List<Integer> manualTicket : manualTickets) {
			tickets.add(createManualTicket(manualTicket));
		}
	}

	private Lotto createManualTicket(List<Integer> ticket) {
		return new Lotto(ticket);
	}

	private List<Integer> createRandomNumbers() {
		Collections.shuffle(numbers);
		return numbers.stream().limit(6).collect(Collectors.toList());
	}


}
