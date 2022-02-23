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

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int countAnswer(Set<Integer> winningNumbers) {
        int count = 0;
        for (int index = START_INDEX; index < winningNumbers.size(); index++) {
            if (winningNumbers.contains(numbers.get(index))) {
                count++;
            }
        }
        return count;
    }
}
