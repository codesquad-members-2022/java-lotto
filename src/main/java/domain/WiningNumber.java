package domain;

import view.InputView;

import java.util.List;

public class WiningNumber extends Lotto{
    private int bonusNumber;

    public WiningNumber(List<Integer> numbers) {
        super(numbers);
        bonusNumber = Integer.parseInt(InputView.bonusNumber());
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.numbers.contains(bonusNumber);
    }
}
