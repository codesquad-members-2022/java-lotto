package PACKAGE_NAME.domain;

import java.util.List;

public class LottoTicket {

    private List<Integer> numbers;
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return "LottoTicket{" +
                "numbers=" + numbers +
                '}';
    }

    public int countAnswer(List<Integer> winningNumbers) {
        int count = 0;
        for(int  index = 0; index < winningNumbers.size();index++){
            if(winningNumbers.contains(numbers.get(index))){
                count++;
            }
        }
        return count;
    }
}
