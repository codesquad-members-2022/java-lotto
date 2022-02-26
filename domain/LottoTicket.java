package PACKAGE_NAME.domain;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class LottoTicket {

    private List<LottoNumber> numbers;
    private static final int START = 0;
    private static final int VALID_COUNT = 6;

    public LottoTicket(List<LottoNumber> numbers) {
        validateCount(numbers);
        this.numbers = numbers;
    }

    private void validateCount(List<LottoNumber> numbers) {
        if (numbers.size() != VALID_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    public Rank getRank(Set<LottoNumber> winningNumbers, BonusNumber bonusNumber) {
        int countExceptBonus = (int) getWinningNumberCount(winningNumbers);
        return calculateBonusNumber(countExceptBonus,bonusNumber,winningNumbers);
    }

    private long getWinningNumberCount(Set<LottoNumber> winningNumbers) {
        int end = winningNumbers.size();
        return IntStream.range(START, end)
                .filter(index -> countByIndex(winningNumbers, index))
                .count();
    }

    private boolean countByIndex(Set<LottoNumber> winningNumbers, int index){
        LottoNumber lottoNumber = this.numbers.get(index);
        return winningNumbers.contains(lottoNumber);
    }

    private Rank calculateBonusNumber(int count, BonusNumber bonusNumber, Set<LottoNumber> winningNumbers) {
        if(bonusNumber.isElementsOf(winningNumbers)){
            count++;
            return Rank.getRank(count,TRUE);
        }
        return Rank.getRank(count,FALSE);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
