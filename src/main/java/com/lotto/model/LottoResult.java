package com.lotto.model;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class LottoResult {
	private Map<Rank, Integer> result = new LinkedHashMap<>();

	public LottoResult() {
		initResultMap();
	}

	public void check(int ticketResult, boolean bonusResult) {
		if(ticketResult < 3) return;
		Rank rank = Rank.checkRank(ticketResult, bonusResult);
		result.put(rank, result.get(rank) + 1);
	}

	public Map<Rank, Integer> getResult() {
		return Collections.unmodifiableMap(result);
	}

	private void initResultMap() {
		for (Rank rank : Rank.values()) {
			result.put(rank, 0);
		}
	}
}
