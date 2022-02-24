package com.lotto.model;

import java.util.List;

public class Lotto {
	private final List<Integer> ticket;

	public Lotto(List<Integer> ticket) {
		this.ticket = List.copyOf(ticket);
	}

	public List<Integer> getTicket() {
		return ticket;
	}
}
