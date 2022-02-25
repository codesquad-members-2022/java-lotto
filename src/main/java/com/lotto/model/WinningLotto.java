package com.lotto.model;

import java.util.List;

public class WinningLotto {
	private final int bonusNumber;
	private final Lotto numbers;

	public WinningLotto(List<Integer> ticket, int bonusNumber) {
		this.numbers = new Lotto(ticket);
		this.bonusNumber = bonusNumber;
	}

	public boolean compareBonusNumber(List<Integer> ticket) {
		return ticket.stream().anyMatch(s -> bonusNumber == s);
	}

	public int compareTicket(List<Integer> ticket) {
		int matchedCount = 0;
		for (int number : ticket) {
			matchedCount += containNumber(number);
		}
		return matchedCount;
	}

	private int containNumber(int number) {
		if (this.numbers.getTicket().contains(number)) {
			return 1;
		}
		return 0;
	}
}
