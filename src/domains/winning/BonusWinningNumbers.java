package domains.winning;

import java.util.List;

public class BonusWinningNumbers extends WinningNumbers{
	private final int bonus;

	public BonusWinningNumbers(List<Integer> winningNumbers, int bonus) {
		super(winningNumbers);
		this.bonus = bonus;
	}

	public int getBonus() {
		return bonus;
	}
}
