package lotto.domain;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class LottoMatcher {

	private final Map<Lotto, Integer> numOfMatchingResult;
	private final Map<Rank, Integer> rankResult;

	public LottoMatcher() {
		this.numOfMatchingResult = new HashMap<>();
		this.rankResult = new EnumMap<>(Rank.class);
	}

	public void getResult(List<Lotto> buyedLottos, LuckyLotto luckyLotto) {
		for (Lotto lotto : buyedLottos) {
			int count = matchWithLuckyNumber(lotto, luckyLotto);
			numOfMatchingResult.put(lotto, count);
		}
	}

	private int matchWithLuckyNumber(Lotto lotto, LuckyLotto luckyLotto) {
		int count = 0;
		for (int luckyNumber : luckyLotto.getNumbers()) {
			count = getNumOfMatch(lotto, count, luckyNumber);
		}
		return count;
	}

	private int getNumOfMatch(Lotto lotto, int count, int luckyNumber) {
		if (lotto.getNumbers().contains(luckyNumber)) {
			count++;
		}
		return count;
	}

	public void matchRank(LuckyLotto luckyLotto) {
		initRankResult();
		for (Lotto lotto : numOfMatchingResult.keySet()) {
			boolean isMatchBonusNumber = lotto.getNumbers().contains(luckyLotto.getBonusNumber());
			Rank rank = Rank.create(numOfMatchingResult.get(lotto), isMatchBonusNumber);
			putOnlyWinningLottery(rank);
		}
	}

	private void initRankResult() {
		Rank[] values = Rank.values();
		for (Rank value : values) {
			rankResult.put(value, 0);
		}
	}

	private void putOnlyWinningLottery(Rank rank) {
		if (!Objects.isNull(rank)) {
			rankResult.put(rank, rankResult.get(rank) + 1);
		}
	}

	public double getEarningRate(int numberOfLottos) {
		int total = getTotalEarning();
		int pay = numberOfLottos * Lotto.PRICE;
		return
			((total - pay) / (double) pay) * 100;
	}

	private int getTotalEarning() {
		int total = 0;
		for (Rank rank : rankResult.keySet()) {
			total += rankResult.get(rank) * rank.getWinningMoney();
		}
		return total;
	}

	public Map<Rank, Integer> getRankResult() {
		return rankResult;
	}
}
