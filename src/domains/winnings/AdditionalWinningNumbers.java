package domains.winnings;

import java.util.List;

public abstract class AdditionalWinningNumbers implements BasicWinningNumbers{
	private final BasicWinningNumbers winningNumbers;

	protected AdditionalWinningNumbers(BasicWinningNumbers winningNumbers) {
		this.winningNumbers = winningNumbers;
	}

	@Override
	public List<Integer> getNumbers() {
		return winningNumbers.getNumbers();
	}

	protected abstract int getBonus();
}
