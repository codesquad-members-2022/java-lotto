package domain;

import java.util.HashSet;
import java.util.List;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers, int bonusNumber)  throws IllegalArgumentException {
        winningNumbers.add(bonusNumber);
        validate(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validate(List<Integer> winningNumbers) throws IllegalArgumentException {
        checkAmount(winningNumbers.size());
        checkDuplicatedNumber(winningNumbers);
        for (int number : winningNumbers) {
            checkNumberRange(number);
        }
    }

    private void checkAmount(int amount) throws IllegalArgumentException{
        if (amount != LottoGenerator.LOTTO_NUMBER_SIZE + 1) {
            throw new IllegalArgumentException("적절한 당첨 번호 개수가 아닙니다!!");
        }
    }

    private void checkDuplicatedNumber(List<Integer> list) throws IllegalArgumentException {
        HashSet<Integer> hashSet = new HashSet<>(list);
        if (hashSet.size() != list.size()) {
            throw new IllegalArgumentException("중복된 당첨번호는 입력할 수 없습니다!!");
        }
    }

    private void checkNumberRange(int number)  throws IllegalArgumentException{
        if ((LottoGenerator.LOTTO_NUMBER_MIN > number) || (number
            > LottoGenerator.LOTTO_NUMBER_MAX)) {
            throw new IllegalArgumentException("적절한 당첨 번호가 아닙니다!!");
        }
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
