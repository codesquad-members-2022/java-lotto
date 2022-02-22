package model;

import java.util.List;

public class Lotto {
	private List<Integer> ticket;

	public Lotto(List<Integer> ticket) {
		this.ticket = ticket;
	}

	public List<Integer> getTicket() {
		return ticket;
	}
}
