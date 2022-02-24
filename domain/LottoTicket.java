package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Set;

public class LottoTicket {

    private List<Integer> numbers;
    private static final int START_INDEX = 0;
    private static final int VALID_COUNT = 6;

    public LottoTicket(List<Integer> numbers) {
        validateCount(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<Integer> numbers) {
        if (numbers.size() != VALID_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Rank getRank(Set<Integer> winningNumbers, BonusNumber bonusNumber) {
        int count = 0;
        for (int index = START_INDEX; index < winningNumbers.size(); index++) {
            if (winningNumbers.contains(numbers.get(index))) {
                count++;
            }
        }
        return calculateBonus(winningNumbers,bonusNumber,count);
    }

    private Rank calculateBonus(Set<Integer> winningNumbers, BonusNumber bonusNumber, int count) {
        if(bonusNumber.isElementsOf(winningNumbers)){
            count++;
            return Rank.getRank(count,true);
        }
        return Rank.getRank(count,false);
    }
}
