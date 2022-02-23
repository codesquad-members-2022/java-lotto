package model;

import java.util.Collections;
import java.util.List;

public class Lotto {
	private final List<Integer> ticket;

	public Lotto(List<Integer> ticket) {
		this.ticket = List.copyOf(ticket);
	}

	public List<Integer> getTicket() {
		return Collections.unmodifiableList(ticket);
	}
}
