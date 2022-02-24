package domains;

import java.util.List;

public class BonusWinningNumbers implements AddedWinningNumbers{
	private final List<Integer> winningNumbers;
	private final int bonusBall;

	public BonusWinningNumbers(List<Integer> winningNumbers, int bonusBall) {
		this.winningNumbers = winningNumbers;
		this.bonusBall = bonusBall;
	}

	@Override
	public int getBonus() {
		return this.bonusBall;
	}

	@Override
	public List<Integer> getNumbers() {
		return this.winningNumbers;
	}
}
