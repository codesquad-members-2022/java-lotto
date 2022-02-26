package domains.user;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import domains.winning.BonusWinningNumbers;
import domains.winning.Ranking;

public class Lotto {
	public static final int  MINIMUM_NUMBER_OF_WINNING = 3;
	public static final String ERROR_OF_LOTTO_PARAMS = "error of lotto params";
	private final List<Integer> sixNumbers;

	public Lotto(List<Integer> sixNumbers) {
		if (Objects.isNull(sixNumbers)) {
			throw new IllegalArgumentException(ERROR_OF_LOTTO_PARAMS);
		}
		if (sixNumbers.size() < 6) {
			throw new IllegalArgumentException(ERROR_OF_LOTTO_PARAMS);
		}
		Collections.sort(sixNumbers);
		this.sixNumbers = sixNumbers;
	}

	public void recordRanking(BonusWinningNumbers winningNumbers, Ranking ranking){
		boolean checkedBonus = false;
		List<Integer> winning = winningNumbers.getNumbers();
		int winningCount = countWinningNumber(winning);

		if (winningCount >= MINIMUM_NUMBER_OF_WINNING) {
			checkedBonus = this.getBonus(winningNumbers.getBonus());
		}
		ranking.record(checkedBonus, winningCount);
	}

	private int countWinningNumber(List<Integer> winning) {
		return Math.toIntExact(winning.stream()
			.filter(winningNumber -> this.sixNumbers.contains(winningNumber))
			.count());
	}

	private int getCount(int count, Integer winningNumber) {
		if (sixNumbers.contains(winningNumber)) {
			count++;
		}
		return count;
	}

	public boolean getBonus(int bonusNumber) {
		return sixNumbers.contains(bonusNumber);
	}
}
